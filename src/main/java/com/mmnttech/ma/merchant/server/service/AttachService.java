package com.mmnttech.ma.merchant.server.service;


import com.mmnttech.ma.merchant.server.common.entity.DictionaryConst;
import com.mmnttech.ma.merchant.server.common.exception.DatabaseException;
import com.mmnttech.ma.merchant.server.mapper.AttachMapper;
import com.mmnttech.ma.merchant.server.model.Attach;
import com.mmnttech.ma.merchant.server.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Stelo
 * @createAt 2018/1/12
 **/

@Service("attachService")
public class AttachService implements DictionaryConst {

    private Logger logger = LoggerFactory.getLogger(AttachService.class);

    @Autowired
    private AttachMapper attachMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Attach create(Attach attach) {
        attachMapper.insert(attach);
        return attach;
    }

    @Transactional(rollbackFor = DatabaseException.class)
    public List<Attach> createAll(List<Attach> attachListElements, String masterId) {
        List<Attach> result = new ArrayList<>();
        for (Attach element : attachListElements) {
            element.setMasterId(masterId);
            element.setRecId(StringUtil.getUUID());
            if (attachMapper.insert(element) != 1) {
                throw new DatabaseException("error.attach.insert");
            }
            result.add(element);
        }
        return result;
    }

    //查询商家认证信息相关附件
    public List<Map<String, Object>> findMerchantInfoByMasterId(String masterId) {
        List<Object> paramLst = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM t_attach WHERE master_id = ? AND (type = ? OR type = ? OR type = ? OR type = ? OR type = ?)");
        paramLst.add(masterId);
        paramLst.add(AttachType.HEAD_IMAGE.getValue());
        paramLst.add(AttachType.ID_FRONT_IMAGE.getValue());
        paramLst.add(AttachType.ID_BACK_IMAGE.getValue());
        paramLst.add(AttachType.MERCHANT_LICENSE_IMAGE.getValue());
        paramLst.add(AttachType.MERCHANT_QR.getValue());
        List<Map<String, Object>> records = jdbcTemplate.queryForList(sql.toString(), paramLst.toArray());
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, Object> target : records) {
            result.add(attachFormater(target));
        }
        return result;
    }

    private Map<String, Object> attachFormater(Map<String, Object> target) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            target.put("create_date", format.format(target.get("create_date")));
            target.put("type", AttachType.forValue(target.get("type").toString()));
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
        return target;
    }
}
