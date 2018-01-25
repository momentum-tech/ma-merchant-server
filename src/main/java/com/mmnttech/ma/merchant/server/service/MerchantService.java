package com.mmnttech.ma.merchant.server.service;

import com.mmnttech.ma.merchant.server.common.dto.MerchantDto;
import com.mmnttech.ma.merchant.server.common.entity.DictionaryConst;
import com.mmnttech.ma.merchant.server.common.exception.DatabaseException;
import com.mmnttech.ma.merchant.server.entity.MerchantAuth;
import com.mmnttech.ma.merchant.server.mapper.AttachMapper;
import com.mmnttech.ma.merchant.server.mapper.MerchantMapper;
import com.mmnttech.ma.merchant.server.mapper.TaskMapper;
import com.mmnttech.ma.merchant.server.model.*;
import com.mmnttech.ma.merchant.server.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @类名 MerchantService
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月6日 下午5:07:34
 * @版本 v1.0
 * 
 */

@Transactional(rollbackFor = DatabaseException.class)
@Service("merchantService")
public class MerchantService implements DictionaryConst {

    private Logger logger = LoggerFactory.getLogger(MerchantService.class);

    protected static final String MerchantCertTaskType = "01";

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private AttachService attachService;
    
    @Autowired
    private AttachMapper attachMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MerchantCertService merchantCertService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = DatabaseException.class)
    public MerchantDto createMerchant(MerchantDto merchantDto) {
        Merchant merchant = merchantDto.getMerchant();
        merchant.setAuthStep(MerchantAuthType.BASIC_INFO.getValue());
        merchant.setComStat(MerchantComStat.COM_STAT_WAITING_4_AUTHORIZETION.getValue());
        merchantMapper.updateByPrimaryKeySelective(merchant);
        List<Attach> attachList = attachService.createAll(merchantDto.getAttachList(), merchantDto.getMerchant().getRecId());
        if (attachList.isEmpty()) {
            throw new DatabaseException("error.merchant.insert");
        }
        if (!createMerchantCertTask(merchantDto.getMerchant())) {
            throw new DatabaseException("error.task.insert");
        }
        merchantDto.setMerchant(merchant);
        merchantDto.setAttachList(attachList);
        return merchantDto;
    }

    public Map<String, Object> queryMerchantById(String recId) {
        List<Object> paramLst = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM t_merchant WHERE rec_id = ?");
        paramLst.add(recId);
        Map<String, Object> record = jdbcTemplate.queryForMap(sql.toString(), paramLst.toArray());
        return merchantFormater(record);
    }

    public Map<String, Object> queryMerchantDetailInfoById(String recId) {
        Map<String, Object> result = new HashMap<>();
        result.put("merchant", queryMerchantById(recId));
        result.put("attach", attachService.findMerchantInfoByMasterId(recId));
        return result;
    }

    public List<String> queryRecIdByCpyName(String cpyName) {
        return merchantMapper.queryRecIdByCpyName(cpyName);
    }

    private Boolean createMerchantCertTask(Merchant merchant) {
        List<MerchantCert> merchantCerts = merchantCertService.queryMerchantCertByAreaCodeAndIndustryCode(merchant.getAreaCode(), merchant.getIndustryCode());
        List<Task> taskList = new LinkedList<>();
        for (MerchantCert curMerchant : merchantCerts) {
            Task task = new Task();
            task.setStatus(TaskStatus.STATUS_STANDBY.getValue());
            task.setType(TaskType.TYPE_MERCHANT.getValue());
            task.setTaskDesc("诚信商户认证");
            task.setRoleId(roleService.queryRoleById(curMerchant.getRoleId()).getRecId());
            task.setData(merchant.getRecId());
            taskList.add(task);
        }
        if (!taskService.createTaskList(taskList).isEmpty()) {
            return true;
        }
        return false;
    }

    @Transactional
	public void txMerchantAuth(MerchantAuth merchantAuth, List<Attach> attachLst, Role role) {
    	StringBuffer taskDesc = new StringBuffer();
    	taskDesc.append("认证商户(").append(merchantAuth.getCpyName()).append(")");
        merchantAuth.setAuthStep(MerchantAuthType.BASIC_INFO.getValue());
        merchantAuth.setComStat(MerchantComStat.COM_STAT_WAITING_4_AUTHORIZETION.getValue());
        merchantMapper.updateByPrimaryKeySelective(merchantAuth);

		Task task = new Task();
		task.setRecId(StringUtil.getUUID());
		task.setCreateDate(new Date());
		task.setTaskDesc(taskDesc.toString());
        task.setStatus(TaskStatus.STATUS_STANDBY.getValue());
        task.setType(TaskType.TYPE_MERCHANT.getValue());
        task.setMainId(merchantAuth.getRecId());
        task.setRoleId(role.getRecId());
		taskMapper.insert(task);

		for(Attach record : attachLst) {
			record.setRecId(StringUtil.getUUID());
			record.setCreateDate(new Date());
			record.setMasterId(merchantAuth.getRecId());
			
			attachMapper.insert(record);
		}
		
	}

    private Map<String, Object> merchantFormater(Map<String, Object> target) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            target.put("create_date", format.format(target.get("create_date")));
            target.put("date", format.format(target.get("date")));
            target.put("auth_step", MerchantAuthType.forValue(target.get("auth_step").toString()));
            target.put("com_stat", MerchantComStat.forValue(target.get("com_stat").toString()));
            target.put("stat", MerchantStat.forValue(target.get("stat").toString()));
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
        return target;
    }

}
