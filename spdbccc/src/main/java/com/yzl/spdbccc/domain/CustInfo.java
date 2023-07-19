package com.yzl.spdbccc.domain;

/**
 * 客户信息
 * @Author 俞泽笠
 * @Date 2023/7/18
 **/
public class CustInfo {
    private Integer custBal;

    private String cd;
    private String outDate;

    private String branchName;

    private Integer custInstResidualBal;
    private String custName;
    private Integer custUsdBal;
    private String outEndDate;
    private Integer principal;
    private String custNbr;
    private String reduceFlag;

    private String queueName;

    private String cityName;
    private String custId;
    private Integer dpd;
    private Integer custRmbBal;

    public Integer getCustBal() {
        return custBal;
    }

    public void setCustBal(Integer custBal) {
        this.custBal = custBal;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Integer getCustInstResidualBal() {
        return custInstResidualBal;
    }

    public void setCustInstResidualBal(Integer custInstResidualBal) {
        this.custInstResidualBal = custInstResidualBal;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Integer getCustUsdBal() {
        return custUsdBal;
    }

    public void setCustUsdBal(Integer custUsdBal) {
        this.custUsdBal = custUsdBal;
    }

    public String getOutEndDate() {
        return outEndDate;
    }

    public void setOutEndDate(String outEndDate) {
        this.outEndDate = outEndDate;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }

    public String getCustNbr() {
        return custNbr;
    }

    public void setCustNbr(String custNbr) {
        this.custNbr = custNbr;
    }

    public String getReduceFlag() {
        return reduceFlag;
    }

    public void setReduceFlag(String reduceFlag) {
        this.reduceFlag = reduceFlag;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Integer getDpd() {
        return dpd;
    }

    public void setDpd(Integer dpd) {
        this.dpd = dpd;
    }

    public Integer getCustRmbBal() {
        return custRmbBal;
    }

    public void setCustRmbBal(Integer custRmbBal) {
        this.custRmbBal = custRmbBal;
    }
}
