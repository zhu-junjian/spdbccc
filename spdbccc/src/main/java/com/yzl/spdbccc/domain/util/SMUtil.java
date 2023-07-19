//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.yzl.spdbccc.domain.util;

import com.spdbccc.KeypairGenerate;
import com.spdbccc.SM2Signature;
import com.spdbccc.SM3Digest;
import com.spdbccc.SM4Crypto;
import com.spdbccc.util.Util;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.DatatypeConverter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SMUtil {
    private static final Logger logger = LoggerFactory.getLogger(SMUtil.class);
    static ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(1, 100, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(16));

    private SMUtil() {
        throw new UnsupportedOperationException("工具类不支持实例化");
    }

    static final void verifySign(String publicKey, String clientId, String data, String sign) {
        logger.info("签名：{}", sign);
        String respDigest = SM3Digest.digest(clientId.concat(data).getBytes());
        logger.info("摘要：{}", respDigest);

        boolean verify;
        try {
            verify = SM2Signature.verifySign(publicKey, clientId, Util.hexStringToBytes(sign), respDigest.getBytes());
        } catch (Exception var7) {
            throw new RuntimeException("验签出错", var7);
        }

        if (!verify) {
            throw new RuntimeException("验签失败");
        }
    }

    static final String createSign(String timestamp, String data, String clientId, String privateKey) {
        String signStr = timestamp.concat(clientId).concat(data);
        logger.info("待签名字符串：{}", signStr);
        String digest = SM3Digest.digest(signStr.getBytes());
        logger.info("待签名字符串的SM3摘要：{}", digest);

        try {
            byte[] signByte = SM2Signature.createSign(privateKey, clientId, digest.getBytes());
            String sign = Hex.encodeHexString(signByte).toUpperCase();
            logger.info("生成的签名：{}", sign);
            return sign;
        } catch (Exception var8) {
            throw new RuntimeException("生成签名失败", var8);
        }
    }

    static final String encrypt(String data, String sm4Secret) {
        logger.info("明文数据：{}", data);
        logger.info("密钥：{}", sm4Secret);

        try {
            byte[] encrypted = SM4Crypto.encrypt(data.getBytes(), sm4Secret);
            String encryptData = DatatypeConverter.printBase64Binary(encrypted);
            logger.info("加密结果：{}", encryptData);
            return encryptData;
        } catch (Exception var4) {
            throw new RuntimeException("SM4加密失败", var4);
        }
    }

    static final String decrypt(String encryptData, String sm4Secret) {
        logger.info("密文数据：{}", encryptData);
        logger.info("密钥：{}", sm4Secret);

        try {
            String data = new String(SM4Crypto.decrypt(DatatypeConverter.parseBase64Binary(encryptData), sm4Secret));
            logger.info("解密后的明文：{}", data);
            return data;
        } catch (Exception var3) {
            throw new RuntimeException("SM4解密失败", var3);
        }
    }

    public static final void keyPair() {
        String[] keys = (new KeypairGenerate()).generateKeyPair();
        System.out.println("公钥: [" + keys[0] + "]");
        System.out.println("私钥: [" + keys[1] + "]");
    }
}
