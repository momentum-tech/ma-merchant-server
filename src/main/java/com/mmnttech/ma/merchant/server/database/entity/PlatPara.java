package com.mmnttech.ma.merchant.server.database.entity;

public class PlatPara {
    private String platNo;

    private String platName;

    private String platStat;

    private String platDate;

    private String preDate;

    public String getPlatNo() {
        return platNo;
    }

    public void setPlatNo(String platNo) {
        this.platNo = platNo == null ? null : platNo.trim();
    }

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName == null ? null : platName.trim();
    }

    public String getPlatStat() {
        return platStat;
    }

    public void setPlatStat(String platStat) {
        this.platStat = platStat == null ? null : platStat.trim();
    }

    public String getPlatDate() {
        return platDate;
    }

    public void setPlatDate(String platDate) {
        this.platDate = platDate == null ? null : platDate.trim();
    }

    public String getPreDate() {
        return preDate;
    }

    public void setPreDate(String preDate) {
        this.preDate = preDate == null ? null : preDate.trim();
    }
}