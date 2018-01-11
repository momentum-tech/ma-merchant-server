package com.mmnttech.ma.merchant.server.database.entity;

import java.util.Date;

public class Attach {
    private String recId;

    private String masterId;

    private Integer seriNo;

    private String type;

    private String name;

    private String attachUrl;

    private String comMemo;

    private Date createDate;

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId == null ? null : recId.trim();
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId == null ? null : masterId.trim();
    }

    public Integer getSeriNo() {
        return seriNo;
    }

    public void setSeriNo(Integer seriNo) {
        this.seriNo = seriNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAttachUrl() {
        return attachUrl;
    }

    public void setAttachUrl(String attachUrl) {
        this.attachUrl = attachUrl == null ? null : attachUrl.trim();
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