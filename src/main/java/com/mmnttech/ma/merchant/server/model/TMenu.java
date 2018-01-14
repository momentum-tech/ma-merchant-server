package com.mmnttech.ma.merchant.server.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_menu")
public class TMenu {
    @Id
    @Column(name = "rec_id")
    private String recId;

    private String name;

    private String identity;

    private String html;

    @Column(name = "menu_group_id")
    private String menuGroupId;

    @Column(name = "create_date")
    private Date createDate;

    private Integer sequence;

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
     * @return identity
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * @param identity
     */
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    /**
     * @return html
     */
    public String getHtml() {
        return html;
    }

    /**
     * @param html
     */
    public void setHtml(String html) {
        this.html = html;
    }

    /**
     * @return menu_group_id
     */
    public String getMenuGroupId() {
        return menuGroupId;
    }

    /**
     * @param menuGroupId
     */
    public void setMenuGroupId(String menuGroupId) {
        this.menuGroupId = menuGroupId;
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
     * @return sequence
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * @param sequence
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}