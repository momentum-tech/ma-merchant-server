package com.mmnttech.ma.merchant.server.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.mmnttech.ma.merchant.server.common.exception.DatabaseException;
import com.mmnttech.ma.merchant.server.mapper.ComplaintMapper;
import com.mmnttech.ma.merchant.server.model.Complaint;

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
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Complaint queryComplaintByRecId(String recId) {
        return complaintMapper.selectByPrimaryKey(recId);
    }

    public List<Map<String, Object>> queryComplaintByMerchantId(String merchantId, int page, int rows) {
    	List<Object> paramLst = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM t_complaint WHERE merchant_id = ?");
		paramLst.add(merchantId);
		
		int offset = (page - 1) * rows;
		
		sql.append(" ORDER BY create_date desc LIMIT ?, ?");
		paramLst.add(offset);
		paramLst.add(rows);
		
		List<Map<String, Object>> records = jdbcTemplate.queryForList(sql.toString(), paramLst.toArray());
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		for(Map<String, Object> record : records) {
			record.put("create_date", format.format(record.get("create_date")));
			record.put("date", format.format(record.get("date")));
		}
        return records;
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
