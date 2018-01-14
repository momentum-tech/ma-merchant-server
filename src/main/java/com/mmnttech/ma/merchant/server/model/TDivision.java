package com.mmnttech.ma.merchant.server.model;

import javax.persistence.*;

@Table(name = "t_division")
public class TDivision {
    @Id
    @Column(name = "div_code")
    private String divCode;

    @Column(name = "div_name")
    private String divName;

    @Column(name = "short_name")
    private String shortName;

    /**
     * @return div_code
     */
    public String getDivCode() {
        return divCode;
    }

    /**
     * @param divCode
     */
    public void setDivCode(String divCode) {
        this.divCode = divCode;
    }

    /**
     * @return div_name
     */
    public String getDivName() {
        return divName;
    }

    /**
     * @param divName
     */
    public void setDivName(String divName) {
        this.divName = divName;
    }

    /**
     * @return short_name
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}