package com.mmnttech.ma.merchant.server.service;

import com.github.pagehelper.PageHelper;
import com.mmnttech.ma.merchant.server.common.entity.DictionaryConst;
import com.mmnttech.ma.merchant.server.common.exception.DatabaseException;
import com.mmnttech.ma.merchant.server.mapper.ComplaintMapper;
import com.mmnttech.ma.merchant.server.model.Complaint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public class ComplaintService implements DictionaryConst {

    private Logger logger = LoggerFactory.getLogger(ComplaintService.class);

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
        List<Complaint> complaints = PageHelper.startPage(page, size).doSelectPage(() -> complaintMapper.select(complaint));
        List<Complaint> result = new ArrayList<>();
        for (Complaint c : complaints) {
            c.setStatus(ComplaintsStat.forValue(c.getStatus()).name());
            result.add(c);
        }
        return result;
    }

    //TODO:询问
    public List<Complaint> queryComplaintByMerchantName(String merchantName, int page, int size) {
        List<String> recIdList = merchantService.queryRecIdByCpyName(merchantName);
        Example example = new Example(Complaint.class);
        example.createCriteria()
                .andIn("merchantId", recIdList);
        List<Complaint> complaints = PageHelper.startPage(page, size).doSelectPage(() -> complaintMapper.selectByExample(example));
        List<Complaint> result = new ArrayList<>();
        for (Complaint c : complaints) {
            c.setStatus(ComplaintsStat.forValue(c.getStatus()).name());
            result.add(c);
        }
        return result;
    }

    private Map<String, Object> complaintFormater(Map<String, Object> target) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            target.put("create_date", format.format(target.get("create_date")));
            target.put("date", format.format(target.get("date")));
            target.put("status", ComplaintsStat.forValue(target.get("status").toString()));
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
        return target;
    }

}
