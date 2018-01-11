package com.mmnttech.ma.merchant.server.database.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Merchant {
    private String recId;

    private String cpyName;

    private String industryCode;

    private String areaCode;

    private String categoryCode;

    private String cpyLegalName;

    private String cpyAddress;

    private BigDecimal addressCoorX;

    private BigDecimal addressCoorY;

    private String introduction;

    private String special;

    private String linkman;

    private String svrTel;

    private String authStep;

    private String comStat;

    private String authReason;

    private String stat;

    private String clrAct;

    private String comMemo;

    private Date createDate;

    private String licenseNo;

    private String idCardNo;

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId == null ? null : recId.trim();
    }

    public String getCpyName() {
        return cpyName;
    }

    public void setCpyName(String cpyName) {
        this.cpyName = cpyName == null ? null : cpyName.trim();
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode == null ? null : industryCode.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    public String getCpyLegalName() {
        return cpyLegalName;
    }

    public void setCpyLegalName(String cpyLegalName) {
        this.cpyLegalName = cpyLegalName == null ? null : cpyLegalName.trim();
    }

    public String getCpyAddress() {
        return cpyAddress;
    }

    public void setCpyAddress(String cpyAddress) {
        this.cpyAddress = cpyAddress == null ? null : cpyAddress.trim();
    }

    public BigDecimal getAddressCoorX() {
        return addressCoorX;
    }

    public void setAddressCoorX(BigDecimal addressCoorX) {
        this.addressCoorX = addressCoorX;
    }

    public BigDecimal getAddressCoorY() {
        return addressCoorY;
    }

    public void setAddressCoorY(BigDecimal addressCoorY) {
        this.addressCoorY = addressCoorY;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special == null ? null : special.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getSvrTel() {
        return svrTel;
    }

    public void setSvrTel(String svrTel) {
        this.svrTel = svrTel == null ? null : svrTel.trim();
    }

    public String getAuthStep() {
        return authStep;
    }

    public void setAuthStep(String authStep) {
        this.authStep = authStep == null ? null : authStep.trim();
    }

    public String getComStat() {
        return comStat;
    }

    public void setComStat(String comStat) {
        this.comStat = comStat == null ? null : comStat.trim();
    }

    public String getAuthReason() {
        return authReason;
    }

    public void setAuthReason(String authReason) {
        this.authReason = authReason == null ? null : authReason.trim();
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public String getClrAct() {
        return clrAct;
    }

    public void setClrAct(String clrAct) {
        this.clrAct = clrAct == null ? null : clrAct.trim();
    }

    public String getComMemo() {
        return comMemo;
    }

    public void setComMemo(String comMemo) {
        this.comMemo = comMemo == null ? null : comMemo.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo == null ? null : licenseNo.trim();
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }
}