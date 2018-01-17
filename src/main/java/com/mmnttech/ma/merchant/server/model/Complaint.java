package com.mmnttech.ma.merchant.server.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_complaint")
public class Complaint {
    @Id
    @Column(name = "rec_id")
    private String recId;

    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "integrity_code")
    private String integrityCode;

    @Column(name = "order_id")
    private String orderId;

    private Long amt;

    private String type;

    private Date date;

    private String addr;

    private String message;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_tel")
    private String userTel;

    private String step;

    @Column(name = "result_message")
    private String resultMessage;

    @Column(name = "fair_id")
    private String fairId;

    private String status;

    private Long evaluation;

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
     * @return integrity_code
     */
    public String getIntegrityCode() {
        return integrityCode;
    }

    /**
     * @param integrityCode
     */
    public void setIntegrityCode(String integrityCode) {
        this.integrityCode = integrityCode;
    }

    /**
     * @return order_id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return amt
     */
    public Long getAmt() {
        return amt;
    }

    /**
     * @param amt
     */
    public void setAmt(Long amt) {
        this.amt = amt;
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
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return addr
     */
    public String getAddr() {
        return addr;
    }

    /**
     * @param addr
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

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
     * @return step
     */
    public String getStep() {
        return step;
    }

    /**
     * @param step
     */
    public void setStep(String step) {
        this.step = step;
    }

    /**
     * @return result_message
     */
    public String getResultMessage() {
        return resultMessage;
    }

    /**
     * @param resultMessage
     */
    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    /**
     * @return fair_id
     */
    public String getFairId() {
        return fairId;
    }

    /**
     * @param fairId
     */
    public void setFairId(String fairId) {
        this.fairId = fairId;
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
     * @return evaluation
     */
    public Long getEvaluation() {
        return evaluation;
    }

    /**
     * @param evaluation
     */
    public void setEvaluation(Long evaluation) {
        this.evaluation = evaluation;
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