package com.mmnttech.ma.merchant.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_role_menu_group")
public class RoleMenuGroup {
    @Id
    @Column(name = "rec_id")
    private String recId;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "menu_group_id")
    private String menuGroupId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
     * @return role_id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
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
}