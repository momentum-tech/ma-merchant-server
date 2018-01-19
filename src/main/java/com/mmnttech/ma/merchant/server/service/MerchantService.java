package com.mmnttech.ma.merchant.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmnttech.ma.merchant.server.common.dto.MerchantDto;
import com.mmnttech.ma.merchant.server.common.entity.DictionaryConst;
import com.mmnttech.ma.merchant.server.common.exception.DatabaseException;
import com.mmnttech.ma.merchant.server.entity.MerchantAuth;
import com.mmnttech.ma.merchant.server.mapper.AttachMapper;
import com.mmnttech.ma.merchant.server.mapper.MerchantMapper;
import com.mmnttech.ma.merchant.server.model.Attach;
import com.mmnttech.ma.merchant.server.model.Merchant;
import com.mmnttech.ma.merchant.server.model.MerchantCert;
import com.mmnttech.ma.merchant.server.model.Task;
import com.mmnttech.ma.merchant.server.util.StringUtil;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


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
public class MerchantService {

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
    private JdbcTemplate jdbcTemplate;

    public MerchantDto createMerchant(MerchantDto merchantDto) {
    	Merchant merchant = merchantDto.getMerchant();
        merchant.setRecId(StringUtil.getUUID());
        if (merchantMapper.insert(merchant) == 1) {
            if (!attachService.createAll(merchantDto.getAttachList(), merchant.getRecId())) {
                throw new DatabaseException("error.merchant.insert");
            }
        } else {
            throw new DatabaseException("error.merchant.insert");
        }
        if (!createMerchantCertTask(merchant)) {
            throw new DatabaseException("error.task.insert");
        }
        MerchantDto curMerchant = new MerchantDto();
        curMerchant.setMerchant(merchant);
        curMerchant.setAttachList(attachService.findByMasterId(merchant.getRecId()));
        return curMerchant;
    }
    
    public Merchant queryMerchantById(String recId) {
    	return merchantMapper.selectByPrimaryKey(recId);
    }

    public MerchantDto queryMerchantDetailInfoById(String recId) {
        MerchantDto curMerchant = new MerchantDto();
        curMerchant.setMerchant(merchantMapper.selectByPrimaryKey(recId));
        curMerchant.setAttachList(attachService.findByMasterId(recId));
        return curMerchant;
    }

    public List<String> queryRecIdByCpyName(String cpyName) {
//        return merchantMapper.queryRecIdByCpyName(cpyName);
    	return null;
    }

    private Boolean createMerchantCertTask(Merchant merchant) {
        List<MerchantCert> merchantCerts = merchantCertService.queryMerchantCertByAreaCodeAndIndustryCode(merchant.getAreaCode(), merchant.getIndustryCode());
        List<Task> taskList = new LinkedList<>();
        for (MerchantCert curMerchant : merchantCerts) {
            Task task = new Task();
            task.setType(MerchantCertTaskType);
            task.setTaskDesc("诚信商户认证");
            task.setRole(roleService.queryRoleById(curMerchant.getRoleId()).getRecId());
            task.setData(JSONObject.fromObject(merchant.getRecId()).toString());
            taskList.add(task);
        }
        if (!taskService.createTaskList(taskList).isEmpty()) {
            return true;
        }
        return false;
    }

    @Transactional
	public void txMerchantAuth(MerchantAuth merchantAuth, List<Attach> attachLst) {
		merchantAuth.setAuthStep(DictionaryConst.TMerchant.AUTH_STEP_1);
		merchantAuth.setComStat(DictionaryConst.Common.COM_STAT_WAITING_4_AUTHORIZETION);
		merchantMapper.updateByPrimaryKeySelective(merchantAuth);
		
		for(Attach record : attachLst) {
			record.setRecId(StringUtil.getUUID());
			record.setCreateDate(new Date());
			record.setMasterId(merchantAuth.getRecId());
			
			attachMapper.insert(record);
		}
		
	}

	public Map<String, Object> queryMerchantInfo(String recId) {
		List<Object> paramLst = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT t2.*, CC.category FROM (");
		sql.append("SELECT t1.*, AC.area FROM (");
		sql.append("SELECT MCT.*, IDC.industry FROM (SELECT * FROM t_merchant WHERE rec_id = ?) MCT LEFT JOIN (SELECT * FROM t_industry_code)IDC ON MCT.industry_code = IDC.industry_code");
		sql.append(")t1 LEFT JOIN (SELECT * FROM t_area_code) AC ON t1.area_code = AC.area_code");
		sql.append(")t2 LEFT JOIN (SELECT * FROM t_category_code) CC ON t2.category_code = CC.category_code");
		
		paramLst.add(recId);
		
		return jdbcTemplate.queryForMap(sql.toString(), paramLst.toArray());
	}

}
