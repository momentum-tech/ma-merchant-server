package com.mmnttech.ma.merchant.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_attach")
public class Attach {
    @Id
    @Column(name = "rec_id")
    private String recId;

    @Column(name = "master_id")
    private String masterId;

    @Column(name = "seri_no")
    private Integer seriNo;

    private String type;

    private String name;

    @Column(name = "attach_url")
    private String attachUrl;

    @Column(name = "com_memo")
    private String comMemo;

    @Column(name = "create_date")
    private Date createDate;

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
     * @return master_id
     */
    public String getMasterId() {
        return masterId;
    }

    /**
     * @param masterId
     */
    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    /**
     * @return seri_no
     */
    public Integer getSeriNo() {
        return seriNo;
    }

    /**
     * @param seriNo
     */
    public void setSeriNo(Integer seriNo) {
        this.seriNo = seriNo;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return attach_url
     */
    public String getAttachUrl() {
        return attachUrl;
    }

    /**
     * @param attachUrl
     */
    public void setAttachUrl(String attachUrl) {
        this.attachUrl = attachUrl;
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
}