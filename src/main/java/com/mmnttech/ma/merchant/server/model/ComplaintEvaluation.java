package com.mmnttech.ma.merchant.server.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_complaint_evaluation")
public class ComplaintEvaluation {
    @Id
    @Column(name = "rec_id")
    private String recId;

    @Column(name = "complaint_id")
    private String complaintId;

    private String evaluationer;

    private String origin;

    private String step;

    private String message;

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
     * @return complaint_id
     */
    public String getComplaintId() {
        return complaintId;
    }

    /**
     * @param complaintId
     */
    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    /**
     * @return evaluationer
     */
    public String getEvaluationer() {
        return evaluationer;
    }

    /**
     * @param evaluationer
     */
    public void setEvaluationer(String evaluationer) {
        this.evaluationer = evaluationer;
    }

    /**
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
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