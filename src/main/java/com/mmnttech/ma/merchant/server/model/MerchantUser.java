package com.mmnttech.ma.merchant.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_merchant_user")
public class MerchantUser {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "user_tel")
    private String userTel;

    @Column(name = "user_pwd")
    private String userPwd;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_addr")
    private String userAddr;

    private String email;

    @Column(name = "role_id")
    private String roleId;

    private String status;

    @Column(name = "create_date")
    private Date createDate;

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return merchant_id
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return user_tel
     */
    public String getUserTel() {
        return userTel;
    }

    /**
     * @param userTel
     */
    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    /**
     * @return user_pwd
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * @param userPwd
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_addr
     */
    public String getUserAddr() {
        return userAddr;
    }

    /**
     * @param userAddr
     */
    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
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