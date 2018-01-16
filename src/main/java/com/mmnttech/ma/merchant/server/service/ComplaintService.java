package com.mmnttech.ma.merchant.server.service;

import com.github.pagehelper.PageHelper;
import com.mmnttech.ma.merchant.server.common.exception.DatabaseException;
import com.mmnttech.ma.merchant.server.mapper.ComplaintMapper;
import com.mmnttech.ma.merchant.server.model.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @类名 ComplaintService
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月6日 下午5:07:30
 * @版本 v1.0
 * 
 */

@Transactional(rollbackFor = DatabaseException.class)
@Service("complaintService")
public class ComplaintService {

    @Autowired
    private ComplaintMapper complaintMapper;

    @Autowired
    private MerchantService merchantService;

    public Complaint queryComplaintByRecId(String recId) {
        return complaintMapper.selectByPrimaryKey(recId);
    }

    public List<Complaint> queryComplaintByMerchantId(String merchantId, int page, int size) {
        Complaint complaint = new Complaint();
        complaint.setMerchantId(merchantId);
        return PageHelper.startPage(page, size).doSelectPage(() -> complaintMapper.select(complaint));
    }

    public List<Complaint> queryComplaintByAnyCondition(Complaint complaint, int page, int size) {
        return PageHelper.startPage(page, size).doSelectPage(() -> complaintMapper.select(complaint));
    }

    public List<Complaint> queryComplaintByMerchantName(String merchantName, int page, int size) {
        List<String> recIdList = merchantService.queryRecIdByCpyName(merchantName);
        Example example = new Example(Complaint.class);
        example.createCriteria()
                .andIn("merchantId", recIdList);
        return PageHelper.startPage(page, size).doSelectPage(() -> complaintMapper.selectByExample(example));
    }

}
