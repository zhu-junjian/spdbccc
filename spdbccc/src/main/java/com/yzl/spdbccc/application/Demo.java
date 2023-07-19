//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.yzl.spdbccc.application;

import com.alibaba.fastjson.JSONObject;
import com.yzl.spdbccc.domain.CustInfo;
import com.yzl.spdbccc.domain.config.ApiRequestConfig;
import com.yzl.spdbccc.domain.util.SendUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Demo {
    private static final ApiRequestConfig config = new ApiRequestConfig();
    private static Map<String, Object> encryptInfo = new HashMap<>();
    private static Map<String, Object> bizData = new HashMap<>();
    /**
     * get authToken by invoke 0200001
     */
    private final static String authToken = "BE291343FA29B10C21D0C083461481AD";
    /**
     * 《副本10家新厂商0705》  登录账号
     */
    private final static String COMP_LOGIN_ID = "HZGX_SH005993";
    /**
     * 《副本10家新厂商0705》  appid
     */
    public static final String APPID = "iccs03102307004";
    /**
     * 《服务23075831568-01密钥信息》 CLIENT_ID
     */
    public static final String CLIENT_ID = "bK9KKy5R-yHHJ-SHEt-ftXY-uqXv0BxfhKWZ";
    /**
     * 《服务23075831568-01密钥信息》 合作方私钥
     */
    public static final String HZF_PRIVATE_KEY = "68CD28AC051EDD37149BC98059A0C46EFB525AD5891640E6B65F06F1C897BA8A";
    /**
     * 《服务23075831568-01密钥信息》卡中心公钥
     */
    public static final String KZX_PUBLIC_KEY = "BB414A1183E1794C0A0C1C294157F12DC544292F53F30F21B2912358A8DC4C3BA10A7F31FED12B5971871F52579D01F3F46401D302F83CB242D56081F5A7870B";
    /**
     * SM4密匙 通过 合作方私钥解密后结果
     */
    public static final String ENCODE_SM4_SECRET = "19FAF98AA81DC698";
    /**
     * 《催收系统委外国密接口》 测试环境URL
     */
    public static final String URL = "https://apiuat.spdbccc.com.cn/iccs-cloud-api/sm/gateway";
    /**
     * 《副本10家新厂商0705》  中文简称
     */
    public static final String COMP_SHORT_NAME_EN = "HZGX";

    private final static String acctNbr = "9537203477";

    private final static String custId = "50350206681193";
    private final static String custName = "郭一意";

    private final static String uuid = UUID.randomUUID().toString().replace("-", "");

    public Demo() {
    }

    protected static void putStartDate(Map<String, Object> bizData) {
        bizData.put("startDate", "2023-07-01");
        bizData.put("endDate", "2023-07-30");
    }

    protected static void putCustInfo(Map<String, Object> encryptInfo) {
        encryptInfo.put("custId", custId);
        encryptInfo.put("custName", custName);
    }

    protected static void putComInfo(Map<String, Object> encryptInfo) {
        encryptInfo.put("compLoginId", COMP_LOGIN_ID);
    }

    protected static void putQueueInfo(Map<String, Object> encryptInfo) {
        encryptInfo.put("custNbr", "HZGX67241531643493");
        //encryptInfo.put("queueType", "");
    }

    protected static void putPage(Map<String, Object> bizData) {
        bizData.put("pageNum", 10);
        bizData.put("pageSize", 1);
    }

    public static void main(String[] args) {
        exg100042();
    }

    public static void exg100042() {
        bizData.put("custId", custId);
        bizData.put("queueType", "D");
        bizData.put("branchName", "上海分行");
        bizData.put("startDate", "2023-07-01");
        bizData.put("endDate", "2023-07-30");
        bizData.put("pageNum", 10);
        bizData.put("pageSize", 1);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100042", "1.0.0", bizData, config);
    }

    public static void exg0200015() {
        bizData.put("bizReqNo", authToken);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0200015", "2.0.0", bizData, config);
    }

    public static void exg0200014() {
        bizData.put("custId", authToken);
        bizData.put("custName", authToken);
        bizData.put("acctNbr", authToken);
        bizData.put("cardNbr", authToken);
        bizData.put("templateNo", authToken);
        bizData.put("applyReason", authToken);
        bizData.put("bizReqNo", authToken);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0200014", "2.0.0", bizData, config);
    }

    public static void exg0200013() {
        bizData.put("businessType", "2");
        bizData.put("soundSaveType", "1");
        bizData.put("enableMonthMP", 100);
        bizData.put("enableMonth", "2023-07");
        bizData.put("branchName", "上海分行");
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0200013", "1.0.0", bizData, config);
    }

    public static void exg0200012() {
        encryptInfo.put("bizType", "202306");
        encryptInfo.put("queueName", "HZGX");
        encryptInfo.put("branchName", "02");
        encryptInfo.put("operLocation", "");
        encryptInfo.put("establishDate", "");
        encryptInfo.put("bizQualification", "");
        encryptInfo.put("recordType", "");
        encryptInfo.put("enableManpowerCount", "");
        encryptInfo.put("enableMonth", "");
        bizData.put("bizReqNo", authToken);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0200012", "1.0.0", bizData, config);
    }

    public static void exg0200011() {
        encryptInfo.put("compLoginId", "202306");
        encryptInfo.put("queueType", "HZGX");
        encryptInfo.put("queueName", "02");
        encryptInfo.put("scheduleStartDate", "");
        encryptInfo.put("scheduleEndDate", "");
        encryptInfo.put("operType", "");
        bizData.put("bizReqNo", authToken);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0200011", "1.0.0", bizData, config);
    }

    public static void exg0200010() {
        encryptInfo.put("compLoginId", "202306");
        encryptInfo.put("compUserName", "HZGX");
        encryptInfo.put("branchName", "02");
        encryptInfo.put("operLocationName", "");
        encryptInfo.put("compUserType", "");
        encryptInfo.put("fixTel", "");
        encryptInfo.put("cardTel", "HZGX");
        encryptInfo.put("cardTelUser", "02");
        encryptInfo.put("enableFlag", "");
        encryptInfo.put("modifyReason", "");
        bizData.put("bizReqNo", authToken);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0200010", "1.0.0", bizData, config);
    }

    public static void exg0200009() {
        encryptInfo.put("reportDate", "202306");
        encryptInfo.put("bankName", "HZGX");
        encryptInfo.put("queueName", "02");
        encryptInfo.put("operLocationName", "");
        encryptInfo.put("newFlag", "");
        encryptInfo.put("manpowerNum", "");
        bizData.put("bizReqNo", authToken);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0200009", "1.0.0", bizData, config);
    }

    public static void exg0200008() {
        encryptInfo.put("commisionDate", "202306");
        encryptInfo.put("compShortNameEn", "HZGX");
        encryptInfo.put("queueName", "02");
        encryptInfo.put("compResContractCommision", "");
        encryptInfo.put("compResEncourageCommision", "");
        bizData.put("bizReqNo", authToken);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0200008", "1.0.0", bizData, config);
    }

    public static void exg0200007() {
        encryptInfo.put("achieveDate", "202306");
        encryptInfo.put("compShortNameEn", "HZGX");
        encryptInfo.put("queueName", "02");
        encryptInfo.put("regionName", "");
        encryptInfo.put("branchName", "");
        encryptInfo.put("outTotBalRange", "");
        encryptInfo.put("outDpdRange", "");
        encryptInfo.put("compBackAmt", "1000");
        encryptInfo.put("/compBackRate", "1");
        bizData.put("bizReqNo", authToken);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0200007", "1.0.0", bizData, config);
    }

    public static void exg0200006() {
        Map<String, Object> accts = new HashMap<>();
        //Map<String , Map<String,String>>
        encryptInfo.put("custId", "");
        encryptInfo.put("custName", "");
        encryptInfo.put("reducePlanCode", "");
        encryptInfo.put("applyReason", "");
        encryptInfo.put("notes", "");
        accts.put("", "");
        encryptInfo.put("acctNbr", "");
        encryptInfo.put("custId", "");
        encryptInfo.put("custName", "");
        encryptInfo.put("custId", "");
        encryptInfo.put("custName", "");
        encryptInfo.put("applyReason", "");

        bizData.put("bizReqNo", authToken);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0200006", "2.0.0", bizData, config);
    }

    public static void exg0200005() {
        encryptInfo.put("custId", "");
        encryptInfo.put("custName", "");
        encryptInfo.put("applyReason", "");
        bizData.put("bizReqNo", authToken);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0200005", "2.0.0", bizData, config);
    }

    public static void exg0200004() {
        encryptInfo.put("templateCode", "");
        encryptInfo.put("custId", "");
        encryptInfo.put("custName", "");
        encryptInfo.put("letterAddrType", "");
        encryptInfo.put("letterAddr", "");
        encryptInfo.put("applyReason", "");
        bizData.put("bizReqNo", authToken);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0200004", "2.0.0", bizData, config);
    }

    public static void exg0200003() {
        encryptInfo.put("templateCode", "01");
        encryptInfo.put("custId", custId);
        encryptInfo.put("custName", custName);
        encryptInfo.put("acctNbr", acctNbr);
        encryptInfo.put("cardNbr", "1");
        encryptInfo.put("telephone", "18867886178");
        encryptInfo.put("applyReason", "test");
        bizData.put("bizReqNo", uuid);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0200003", "2.0.0", bizData, config);
    }

    public static void exg0200002() {
        encryptInfo.put("compLoginId", COMP_LOGIN_ID);
        encryptInfo.put("custId", custId);
        encryptInfo.put("custName", custName);
        encryptInfo.put("rCode", "");
        encryptInfo.put("aCode", "OA");
        encryptInfo.put("recordTime", "2023-07-17 00:00:00");
        encryptInfo.put("pCode", "M");
        encryptInfo.put("cCode", "A");
        encryptInfo.put("telephone", "");
        encryptInfo.put("address", "");
        encryptInfo.put("recordContent", "11111");
        encryptInfo.put("contradictoryTime", "");
        bizData.put("bizReqNo", uuid);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0200002", "4.0.0", bizData, config);
    }

    public static void exg41() {
        encryptInfo.put("yearMonth", "");
        encryptInfo.put("queueName", "");
        encryptInfo.put("branchName", "");
        putPage(bizData);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100041", "1.0.0", bizData, config);
    }

    public static void exg40() {
        putCustInfo(encryptInfo);
        putPage(bizData);
        putStartDate(bizData);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100040", "1.0.0", bizData, config);
    }

    public static void exg39() {
        putCustInfo(encryptInfo);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100039", "1.0.0", bizData, config);
    }

    public static void exg38() {
        Map<String, String> record = new HashMap<>();
        encryptInfo.put("record", record);
        record.put("custId", "50350206681193");
        record.put("acctNbr", "");
        record.put("custName", "郭一意");
        putPage(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100038", "1.0.0", bizData, config);

    }

    public static void exg37() {
        putCustInfo(encryptInfo);
        putPage(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100037", "2.0.0", bizData, config);

    }

    public static void exg32() {
        encryptInfo.put("branchName", "上海分行");
        encryptInfo.put("operLocationName", "");
        encryptInfo.put("compLoginId", "");
        encryptInfo.put("compUserNbr", "");
        encryptInfo.put("enableFlag", "");
        putPage(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100032", "1.0.0", bizData, config);

    }

    public static void exg31() {
        putQueueInfo(encryptInfo);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100031", "1.0.0", bizData, config);

    }

    public static void exg30() {
        encryptInfo.put("queueName", "A组");
        encryptInfo.put("yearDate", "202301");
        putPage(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100030", "1.0.0", bizData, config);

    }

    public static void exg29() {
        encryptInfo.put("queueName", "A组");
        encryptInfo.put("branchName", "上海分行");
        putPage(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100029", "1.0.0", bizData, config);

    }

    public static void exg27() {
        encryptInfo.put("queueType", "01");
        putPage(bizData);
        bizData.put("commisionDate", "202306");
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100027", "1.0.0", bizData, config);

    }

    public static void exg26() {
        encryptInfo.put("queueType", "01");
        putPage(bizData);
        bizData.put("achieveDate", "202301");
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100026", "1.0.0", bizData, config);

    }

    public static void exg25() {
        putPage(bizData);
        bizData.put("achieveDate", "202301");
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100025", "1.0.0", bizData, config);
    }

    public static void exg24() {
        encryptInfo.put("custNbr", "HZGX67241531643493");
        encryptInfo.put("queueType", "01");
        putPage(bizData);
        bizData.put("achieveDate", "202307");
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100024", "4.0.0", bizData, config);

    }

    /**
     * 已下线
     */
    public static void exg23() {
        putComInfo(encryptInfo);
        putPage(bizData);
        bizData.put("custId", "");
        bizData.put("custName", "");
        bizData.put("acctNbr", "");
        bizData.put("cardNbr", "");
        bizData.put("bizReqNo", "");
        bizData.put("applyReason", "");
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100023", "2.0.0", bizData, config);

    }

    public static void exg22() {
        putComInfo(encryptInfo);
        putPage(bizData);
        //putStartDate(bizData);
        bizData.put("queryDate", "2023-07-17");
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100022", "1.0.0", bizData, config);

    }

    public static void exg21() {
        putCustInfo(encryptInfo);
        putPage(bizData);
        putStartDate(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100021", "4.0.0", bizData, config);

    }

    public static void exg20() {
        putPage(bizData);
        bizData.put("queryDate", "2023-07-17");
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100020", "4.0.0", bizData, config);

    }

    public static void exg19() {
        putPage(bizData);
        bizData.put("queryDate", "2023-07-17");
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100019", "5.0.0", bizData, config);

    }

    public static void exg18() {
        //putCustInfo(encryptInfo);
        putPage(bizData);
        putStartDate(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100018", "4.0.0", bizData, config);

    }

    public static void exg14() {
        putCustInfo(encryptInfo);
        putPage(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100013", "2.0.0", bizData, config);

    }

    public static void exg13() {
        putCustInfo(encryptInfo);
        putPage(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100013", "2.0.0", bizData, config);

    }

    public static void exg12() {
        putCustInfo(encryptInfo);
        putStartDate(bizData);
        putPage(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100012", "2.0.0", bizData, config);

    }

    public static void exg11() {
        putCustInfo(encryptInfo);
        putStartDate(bizData);
        putPage(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100011", "2.0.0", bizData, config);

    }

    public static void exg10() {
        putCustInfo(encryptInfo);
        putPage(bizData);
        putStartDate(bizData);
        bizData.put("pageNum", 10);
        bizData.put("pageSize", 1);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100010", "2.0.0", bizData, config);

    }

    public static void exg9() {
        putCustInfo(encryptInfo);
        putPage(bizData);
        putStartDate(bizData);
        bizData.put("pageNum", 10);
        bizData.put("pageSize", 1);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100009", "2.0.0", bizData, config);

    }

    public static void exg8() {
        putCustInfo(encryptInfo);
        putPage(bizData);
        encryptInfo.put("acctNbr", acctNbr);
        //请求报文体加密
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100008", "2.0.0", bizData, config);

    }

    public static void exg7() {
        putCustInfo(encryptInfo);
        putPage(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100007", "2.0.0", bizData, config);

    }

    public static void exg6() {
        putCustInfo(encryptInfo);
        putPage(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100006", "2.0.0", bizData, config);

    }

    public static void exg5() {
        putCustInfo(encryptInfo);
        putPage(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100005", "2.0.0", bizData, config);

    }

    public static void exg4() {
        putCustInfo(encryptInfo);
        putPage(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100004", "2.0.0", bizData, config);

    }

    public static void exg3() {
        putCustInfo(encryptInfo);
        putPage(bizData);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100003", "2.0.0", bizData, config);

    }

    public static void exg2() {
        putCustInfo(encryptInfo);
        bizData.put("encryptInfo", encryptInfo);
        bizData.put("authToken", authToken);
        SendUtil.sendRequest("EXG0100002", "5.0.0", bizData, config);
    }

    public static void exg1() {
        bizData.put("pageNum", 1);
        bizData.put("pageSize", 100);
        JSONObject respBody = SendUtil.sendRequest("EXG0100001", "1.0.0", bizData, config);
        //Object ob = JSONObject.parseObject(String.valueOf(respBody)).get("encryptInfo");
        RespBody respBody1 = JSONObject.parseObject(respBody.toJSONString(), RespBody.class);
        /*List<CustInfo> custInfoList = respBody1.getEncryptInfo().getRecords();
        custInfoList.stream().forEach( c ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
                  
            String custName = c.getCustName();
            String custId = c.getCustId();
            encryptInfo.put("custId", custId);
            encryptInfo.put("custName", custName);
            Map<String, Object> bizData1 = new HashMap();
            bizData.put("pageNum", 10);
            bizData.put("pageSize", 1);
            bizData.put("encryptInfo", encryptInfo);
            bizData.put("authToken", authToken);
            JSONObject rb = SendUtil.sendRequest("EXG0100003", "2.0.0", bizData, config);
            RespBody rb1 = JSONObject.parseObject(String.valueOf(rb), RespBody.class);
            if(rb1.getEncryptInfo().getRecords().size()>0){
                System.out.println("有效的custName："+rb1.getEncryptInfo().getRecords().get(0).getCustName());
            }
        });*/
        //   
    }

    public static void exg0200001() {
        encryptInfo.put("compLoginId", "HZGX_SH005993");
        encryptInfo.put("compShortNameEn", "HZGX");
        bizData.put("encryptInfo", encryptInfo);
        SendUtil.sendRequest("EXG0200001", "1.0.0", bizData, config);

    }

    static {
        config.setAppId(APPID);
        config.setClientId(CLIENT_ID);
        config.setHzfPrivateKey(HZF_PRIVATE_KEY);
        config.setKzxPublicKey(KZX_PUBLIC_KEY);
        config.setSm4Secret(ENCODE_SM4_SECRET);
        config.setUrl(URL);
    }
}

class RespBody {
    private Integer totalCount;
    private encryptInfo encryptInfo;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public encryptInfo getEncryptInfo() {
        return encryptInfo;
    }

    public void setEncryptInfo(encryptInfo encryptInfo) {
        this.encryptInfo = encryptInfo;
    }
}

class encryptInfo {
    private String custNbr;
    private List<CustInfo> records;

    public String getCustNbr() {
        return custNbr;
    }

    public void setCustNbr(String custNbr) {
        this.custNbr = custNbr;
    }

    public List<CustInfo> getRecords() {
        return records;
    }

    public void setRecords(List<CustInfo> records) {
        this.records = records;
    }
}