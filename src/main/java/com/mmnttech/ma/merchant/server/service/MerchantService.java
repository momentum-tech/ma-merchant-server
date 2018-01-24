package com.mmnttech.ma.merchant.server.service;

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
    private TaskMapper taskMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = DatabaseException.class)
    public MerchantDto createMerchant(MerchantDto merchantDto) {
        Merchant merchant = merchantDto.getMerchant();
        merchant.setAuthStep(DictionaryConst.TMerchant.AUTH_STEP_1);
        merchant.setComStat(DictionaryConst.Common.COM_STAT_WAITING_4_AUTHORIZETION);
        merchantMapper.updateByPrimaryKeySelective(merchant);
        if (!attachService.createAll(merchantDto.getAttachList(), merchantDto.getMerchant().getRecId())) {
            throw new DatabaseException("error.merchant.insert");
        }
        if (!createMerchantCertTask(merchantDto.getMerchant())) {
            throw new DatabaseException("error.task.insert");
        }
        merchantDto.setAttachList(attachService.findByMasterId(merchantDto.getMerchant().getRecId()));
        return merchantDto;
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
        return merchantMapper.queryRecIdByCpyName(cpyName);
    }

    private Boolean createMerchantCertTask(Merchant merchant) {
        List<MerchantCert> merchantCerts = merchantCertService.queryMerchantCertByAreaCodeAndIndustryCode(merchant.getAreaCode(), merchant.getIndustryCode());
        List<Task> taskList = new LinkedList<>();
        for (MerchantCert curMerchant : merchantCerts) {
            Task task = new Task();
            task.setType(MerchantCertTaskType);
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


		merchantAuth.setAuthStep(DictionaryConst.TMerchant.AUTH_STEP_1);
		merchantAuth.setComStat(DictionaryConst.Common.COM_STAT_WAITING_4_AUTHORIZETION);
		merchantMapper.updateByPrimaryKeySelective(merchantAuth);

		Task task = new Task();
		task.setRecId(StringUtil.getUUID());
		task.setCreateDate(new Date());
		task.setTaskDesc(taskDesc.toString());
		task.setStatus(DictionaryConst.TTask.STATUS_STANDBY);
		task.setType(DictionaryConst.TTask.TYPE_MERCHANT);
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

}
