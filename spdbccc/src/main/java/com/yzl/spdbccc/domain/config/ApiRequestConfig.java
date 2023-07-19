package com.yzl.spdbccc.domain.config;

/**
 * @Author 俞泽笠
 * @Date 2023/7/10
 **/
public class ApiRequestConfig {
    private String appId;
    private String url;
    private String clientId;
    private String sm4Secret;
    private String hzfPrivateKey;
    private String kzxPublicKey;

    public ApiRequestConfig() {
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSm4Secret() {
        return this.sm4Secret;
    }

    public void setSm4Secret(String sm4Secret) {
        this.sm4Secret = sm4Secret;
    }

    public String getHzfPrivateKey() {
        return this.hzfPrivateKey;
    }

    public void setHzfPrivateKey(String hzfPrivateKey) {
        this.hzfPrivateKey = hzfPrivateKey;
    }

    public String getKzxPublicKey() {
        return this.kzxPublicKey;
    }

    public void setKzxPublicKey(String kzxPublicKey) {
        this.kzxPublicKey = kzxPublicKey;
    }

    public String toString() {
        return "appId='" + this.appId + '\'' + ", url='" + this.url + '\'' + ", clientId='" + this.clientId + '\'' + ", sm4Secret='" + this.sm4Secret + '\'' + ", hzfPrivateKey='" + this.hzfPrivateKey + '\'' + ", kzxPublicKey='" + this.kzxPublicKey;
    }
}
