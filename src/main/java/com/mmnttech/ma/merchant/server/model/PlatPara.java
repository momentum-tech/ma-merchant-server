package com.mmnttech.ma.merchant.server.model;

import javax.persistence.*;

@Table(name = "t_plat_para")
public class PlatPara {
    @Id
    @Column(name = "plat_no")
    private String platNo;

    @Column(name = "plat_name")
    private String platName;

    @Column(name = "plat_stat")
    private String platStat;

    @Column(name = "plat_date")
    private String platDate;

    @Column(name = "pre_date")
    private String preDate;

    /**
     * @return plat_no
     */
    public String getPlatNo() {
        return platNo;
    }

    /**
     * @param platNo
     */
    public void setPlatNo(String platNo) {
        this.platNo = platNo;
    }

    /**
     * @return plat_name
     */
    public String getPlatName() {
        return platName;
    }

    /**
     * @param platName
     */
    public void setPlatName(String platName) {
        this.platName = platName;
    }

    /**
     * @return plat_stat
     */
    public String getPlatStat() {
        return platStat;
    }

    /**
     * @param platStat
     */
    public void setPlatStat(String platStat) {
        this.platStat = platStat;
    }

    /**
     * @return plat_date
     */
    public String getPlatDate() {
        return platDate;
    }

    /**
     * @param platDate
     */
    public void setPlatDate(String platDate) {
        this.platDate = platDate;
    }

    /**
     * @return pre_date
     */
    public String getPreDate() {
        return preDate;
    }

    /**
     * @param preDate
     */
    public void setPreDate(String preDate) {
        this.preDate = preDate;
    }
}