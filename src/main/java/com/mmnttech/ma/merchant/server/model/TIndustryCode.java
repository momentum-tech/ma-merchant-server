package com.mmnttech.ma.merchant.server.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_industry_code")
public class TIndustryCode {
    @Id
    @Column(name = "rec_id")
    private String recId;

    @Column(name = "industry_code")
    private String industryCode;

    private String industry;

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
     * @return industry
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * @param industry
     */
    public void setIndustry(String industry) {
        this.industry = industry;
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