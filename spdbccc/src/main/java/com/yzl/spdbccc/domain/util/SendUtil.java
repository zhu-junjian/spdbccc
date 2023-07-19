//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.yzl.spdbccc.domain.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yzl.spdbccc.domain.config.ApiRequestConfig;
import org.apache.http.Header;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.text.SimpleDateFormat;
import java.util.*;

public class SendUtil {
    private static final Logger logger = LoggerFactory.getLogger(SendUtil.class);
    public static final String CLIENTID = "X-SPDBCCC-CLIENTID";
    public static final String TIMESTAMP = "X-SPDBCCC-TIMESTAMP";
    public static final String SIGNATURE = "X-SPDBCCC-SIGNATURE";
    public static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json;charset=utf-8";
    private static final String REQUEST_BODY_FORMAT = "{\"appId\":\"%s\",\"interfaceId\":\"%s\",\"version\":\"%s\",\"reqDateTime\":\"%s\",\"reqTranNo\":\"%s\",\"bizData\":\"%s\"}";

    private SendUtil() {
        throw new UnsupportedOperationException("工具类不支持实例化");
    }

    public static final JSONObject sendRequest(String interfaceId, String version, Object param, ApiRequestConfig config) {
        String appId = config.getAppId();
        String reqTranNo = UUID.randomUUID().toString().replace("-", "");
        String reqDateTime = reqDateTime();
        String bizData = JSON.toJSONString(param, new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
        logger.info("接口请求参数（JSON格式）：{}", bizData);
        String base64BizData = Base64.getEncoder().encodeToString(bizData.getBytes(Charset.forName("UTF-8")));
        String reqBody = String.format("{\"appId\":\"%s\",\"interfaceId\":\"%s\",\"version\":\"%s\",\"reqDateTime\":\"%s\",\"reqTranNo\":\"%s\",\"bizData\":\"%s\"}", appId, interfaceId, version, reqDateTime, reqTranNo, base64BizData);
        logger.info("原始请求报文：{}", reqBody);
        String respBody = execute(reqBody, config);
        JSONObject result = JSONObject.parseObject(respBody);
        respAssert(result, reqTranNo);
        String base64RespBizData = result.getString("bizData");
        logger.info("原始的业务数据(base64)：[{}]", base64RespBizData);
        if (null == base64RespBizData) {
            throw new RuntimeException("响应业务数据为空!");
        } else {
            String respBizData = new String(Base64.getDecoder().decode(base64RespBizData));
            logger.info("base64解码后的业务数据：[{}]", respBizData);
            JSONObject jsonBizData = JSON.parseObject(respBizData);
            logger.info("解析为json对象的业务数据：[{}]", jsonBizData);
            return jsonBizData;
        }
    }

    private static void respAssert(JSONObject result, String reqTranNo) {
        String respTranNo = result.getString("reqTranNo");
        logger.info("请求流水号：[{}]；响应流水号：[{}]", reqTranNo, respTranNo);
        boolean checkReqTranNo = reqTranNo.equals(respTranNo);
        if (!checkReqTranNo) {
            throw new RuntimeException("流水号错误");
        } else {
            String code = result.getString("code");
            logger.info("网关响应码：[{}]", code);
            if (!code.endsWith("000")) {
                throw new RuntimeException(String.format("网关错误：[%s]", result.getString("msg")));
            } else {
                String subCode = result.getString("subCode");
                logger.info("业务响应码：[{}]", subCode);
                if (!subCode.endsWith("000")) {
                    throw new RuntimeException(String.format("业务错误：[%s]", result.getString("subMsg")));
                }
            }
        }
    }

    private static final String execute(String reqBody, ApiRequestConfig config) {
        logger.info("请求配置：[{}]", config);
        String sm4Secret = config.getSm4Secret();
        String encryptReqBody = SMUtil.encrypt(reqBody, sm4Secret);
        String timestamp = dateGMT();
        logger.info("请求时间戳：{}", timestamp);
        String clientId = config.getClientId();
        String privateKey = config.getHzfPrivateKey();
        String sign = SMUtil.createSign(timestamp, encryptReqBody, clientId, privateKey);
        String url = config.getUrl();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json;charset=utf-8");
        post.setHeader("X-SPDBCCC-CLIENTID", clientId);
        post.setHeader("X-SPDBCCC-TIMESTAMP", timestamp);
        post.setHeader("X-SPDBCCC-SIGNATURE", sign);
        post.setEntity(new StringEntity(encryptReqBody, ContentType.APPLICATION_JSON));

        String encryptRespBody;
        String respSign;
        try {
            CloseableHttpClient client = createHttpClient(url);
            Throwable var13 = null;

            try {
                CloseableHttpResponse response = client.execute(post);
                Throwable var15 = null;

                try {
                    StatusLine statusLine = response.getStatusLine();
                    int httpCode = statusLine.getStatusCode();
                    if (200 != httpCode) {
                        throw new RuntimeException(String.format("HTTP响应失败！code=%s，msg=%s", httpCode, statusLine.getReasonPhrase()));
                    }

                    Header header = response.getFirstHeader("X-SPDBCCC-SIGNATURE");
                    if (null == header) {
                        throw new RuntimeException("响应头签名为空");
                    }

                    respSign = header.getValue();
                    encryptRespBody = EntityUtils.toString(response.getEntity());
                    logger.info("原始响应报文：{}", encryptRespBody);
                } catch (Throwable var42) {
                    var15 = var42;
                    throw var42;
                } finally {
                    if (response != null) {
                        if (var15 != null) {
                            try {
                                response.close();
                            } catch (Throwable var41) {
                                var15.addSuppressed(var41);
                            }
                        } else {
                            response.close();
                        }
                    }

                }
            } catch (Throwable var44) {
                var13 = var44;
                throw var44;
            } finally {
                if (client != null) {
                    if (var13 != null) {
                        try {
                            client.close();
                        } catch (Throwable var40) {
                            var13.addSuppressed(var40);
                        }
                    } else {
                        client.close();
                    }
                }

            }
        } catch (Exception var46) {
            throw new RuntimeException(var46.getMessage(), var46);
        }

        SMUtil.verifySign(config.getKzxPublicKey(), clientId, encryptRespBody, respSign);
        return SMUtil.decrypt(encryptRespBody, sm4Secret);
    }

    private static final CloseableHttpClient createHttpClient(String url) {
        if (null != url && url.trim().length() != 0) {
            if (url.startsWith("http://")) {
                return HttpClients.createDefault();
            } else if (url.startsWith("https://")) {
                try {
                    SSLContext sslContext = SSLContexts.custom().loadTrustMaterial((KeyStore)null, new TrustSelfSignedStrategy()).build();
                    SSLConnectionSocketFactory sslFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
                    return HttpClients.custom().setSSLSocketFactory(sslFactory).build();
                } catch (Exception var3) {
                    throw new RuntimeException("SSL错误", var3);
                }
            } else {
                throw new RuntimeException("请求url必须以http或https开头");
            }
        } else {
            throw new RuntimeException("请求url不能为空");
        }
    }

    private static final String reqDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return sdf.format(new Date());
    }

    private static final String dateGMT() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(new Date());
    }
}
