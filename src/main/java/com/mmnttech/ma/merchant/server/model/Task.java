package com.mmnttech.ma.merchant.server.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_task")
public class Task {
    @Id
    @Column(name = "rec_id")
    private String recId;

    private String type;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "task_desc")
    private String taskDesc;

    private String data;

    private String operator;

    private String status;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "begin_time")
    private Date beginTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "main_id")
    private String mainId;

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
     * @return task_desc
     */
    public String getTaskDesc() {
        return taskDesc;
    }

    /**
     * @param taskDesc
     */
    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    /**
     * @return data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
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

    /**
     * @return begin_time
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * @param beginTime
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return main_id
     */
    public String getMainId() {
        return mainId;
    }

    /**
     * @param mainId
     */
    public void setMainId(String mainId) {
        this.mainId = mainId;
    }
}