package com.mmnttech.ma.merchant.server.database.entity;

public class Division {
    private String divCode;

    private String divName;

    private String shortName;

    public String getDivCode() {
        return divCode;
    }

    public void setDivCode(String divCode) {
        this.divCode = divCode == null ? null : divCode.trim();
    }

    public String getDivName() {
        return divName;
    }

    public void setDivName(String divName) {
        this.divName = divName == null ? null : divName.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }
}