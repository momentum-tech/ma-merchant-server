package com.mmnttech.ma.merchant.server.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_role")
public class Role {
    @Id
    @Column(name = "rec_id")
    private String recId;

    private String name;

    private String platform;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "industry_code")
    private String industryCode;

    @Column(name = "area_code")
    private String areaCode;

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
     * @return platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @param platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
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
}