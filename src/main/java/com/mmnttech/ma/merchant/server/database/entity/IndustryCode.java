package com.mmnttech.ma.merchant.server.database.entity;

import java.util.Date;

public class IndustryCode {
    private String recId;

    private String industryCode;

    private String industry;

    private String comMemo;

    private Date createDate;

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId == null ? null : recId.trim();
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode == null ? null : industryCode.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
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