package com.mmnttech.ma.merchant.server.database.entity;

import java.util.Date;

public class AreaCode {
    private String recId;

    private String areaCode;

    private String industry;

    private String level;

    private String comMemo;

    private Date createDate;

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId == null ? null : recId.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
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
}