package com.mmnttech.ma.merchant.server.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_merchant")
public class TMerchant {
    @Id
    @Column(name = "rec_id")
    private String recId;

    @Column(name = "cpy_name")
    private String cpyName;

    @Column(name = "industry_code")
    private String industryCode;

    @Column(name = "area_code")
    private String areaCode;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "cpy_legal_name")
    private String cpyLegalName;

    @Column(name = "cpy_address")
    private String cpyAddress;

    @Column(name = "address_coor_x")
    private BigDecimal addressCoorX;

    @Column(name = "address_coor_y")
    private BigDecimal addressCoorY;

    private String introduction;

    private String special;

    private String linkman;

    @Column(name = "svr_tel")
    private String svrTel;

    @Column(name = "auth_step")
    private String authStep;

    @Column(name = "com_stat")
    private String comStat;

    @Column(name = "auth_reason")
    private String authReason;

    private String stat;

    @Column(name = "clr_act")
    private String clrAct;

    @Column(name = "com_memo")
    private String comMemo;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "license_no")
    private String licenseNo;

    @Column(name = "ID_card_no")
    private String idCardNo;

    /**
     * @return rec_id
     */
    public String getRecId() {
        return recId;
    }

    /**
     * @param recId
     */
    public void setRecId(String recId) {
        this.recId = recId;
    }

    /**
     * @return cpy_name
     */
    public String getCpyName() {
        return cpyName;
    }

    /**
     * @param cpyName
     */
    public void setCpyName(String cpyName) {
        this.cpyName = cpyName;
    }

    /**
     * @return industry_code
     */
    public String getIndustryCode() {
        return industryCode;
    }

    /**
     * @param industryCode
     */
    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    /**
     * @return area_code
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * @param areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * @return category_code
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * @param categoryCode
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * @return cpy_legal_name
     */
    public String getCpyLegalName() {
        return cpyLegalName;
    }

    /**
     * @param cpyLegalName
     */
    public void setCpyLegalName(String cpyLegalName) {
        this.cpyLegalName = cpyLegalName;
    }

    /**
     * @return cpy_address
     */
    public String getCpyAddress() {
        return cpyAddress;
    }

    /**
     * @param cpyAddress
     */
    public void setCpyAddress(String cpyAddress) {
        this.cpyAddress = cpyAddress;
    }

    /**
     * @return address_coor_x
     */
    public BigDecimal getAddressCoorX() {
        return addressCoorX;
    }

    /**
     * @param addressCoorX
     */
    public void setAddressCoorX(BigDecimal addressCoorX) {
        this.addressCoorX = addressCoorX;
    }

    /**
     * @return address_coor_y
     */
    public BigDecimal getAddressCoorY() {
        return addressCoorY;
    }

    /**
     * @param addressCoorY
     */
    public void setAddressCoorY(BigDecimal addressCoorY) {
        this.addressCoorY = addressCoorY;
    }

    /**
     * @return introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * @param introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * @return special
     */
    public String getSpecial() {
        return special;
    }

    /**
     * @param special
     */
    public void setSpecial(String special) {
        this.special = special;
    }

    /**
     * @return linkman
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * @param linkman
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    /**
     * @return svr_tel
     */
    public String getSvrTel() {
        return svrTel;
    }

    /**
     * @param svrTel
     */
    public void setSvrTel(String svrTel) {
        this.svrTel = svrTel;
    }

    /**
     * @return auth_step
     */
    public String getAuthStep() {
        return authStep;
    }

    /**
     * @param authStep
     */
    public void setAuthStep(String authStep) {
        this.authStep = authStep;
    }

    /**
     * @return com_stat
     */
    public String getComStat() {
        return comStat;
    }

    /**
     * @param comStat
     */
    public void setComStat(String comStat) {
        this.comStat = comStat;
    }

    /**
     * @return auth_reason
     */
    public String getAuthReason() {
        return authReason;
    }

    /**
     * @param authReason
     */
    public void setAuthReason(String authReason) {
        this.authReason = authReason;
    }

    /**
     * @return stat
     */
    public String getStat() {
        return stat;
    }

    /**
     * @param stat
     */
    public void setStat(String stat) {
        this.stat = stat;
    }

    /**
     * @return clr_act
     */
    public String getClrAct() {
        return clrAct;
    }

    /**
     * @param clrAct
     */
    public void setClrAct(String clrAct) {
        this.clrAct = clrAct;
    }

    /**
     * @return com_memo
     */
    public String getComMemo() {
        return comMemo;
    }

    /**
     * @param comMemo
     */
    public void setComMemo(String comMemo) {
        this.comMemo = comMemo;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return license_no
     */
    public String getLicenseNo() {
        return licenseNo;
    }

    /**
     * @param licenseNo
     */
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    /**
     * @return ID_card_no
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * @param idCardNo
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }
}