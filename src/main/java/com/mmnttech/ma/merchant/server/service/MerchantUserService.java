package com.mmnttech.ma.merchant.server.service;

import com.mmnttech.ma.merchant.server.common.entity.CommonDictionary;
import com.mmnttech.ma.merchant.server.common.entity.RtnMessage;
import com.mmnttech.ma.merchant.server.mapper.MerchantUserMapper;
import com.mmnttech.ma.merchant.server.mapper.RoleMapper;
import com.mmnttech.ma.merchant.server.model.MerchantUser;
import com.mmnttech.ma.merchant.server.model.Role;
import com.mmnttech.ma.merchant.server.model.SvcUser;
import com.mmnttech.ma.merchant.server.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @类名 MerchantUserService
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月14日 下午7:59:18
 * @版本 v1.0
 * 
 */
@Service("merchantUserService")
public class MerchantUserService {

	@Autowired
	private MerchantUserMapper merchantUserMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	public RtnMessage doLogin(MerchantUser merchantUser) {
		RtnMessage rtnMsg = new RtnMessage();

		Example example = new Example(SvcUser.class);
		example.createCriteria()
				.andEqualTo("user_tel",merchantUser.getUserTel())
				.andEqualTo("user_pwd",StringUtil.MD5(merchantUser.getUserPwd()))
				.andEqualTo("status",CommonDictionary.TSvcUser.STATUS_NORMAL);

		List<MerchantUser> records = merchantUserMapper.selectByExample(example);
		if(records != null && !records.isEmpty()) {
			if(records.size() == 1) {
				MerchantUser record = records.get(0);
				rtnMsg.setRtnObj(record);
			} else {
				rtnMsg.setIsSuccess(false);
				rtnMsg.setMessage(RtnMessage.ERROR_LOGIN_1);
			}
		} else {
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage(RtnMessage.ERROR_LOGIN_1);
		}
		
		return rtnMsg;
	}

	@Transactional
	public RtnMessage txRegists(MerchantUser merchantUser) {
		RtnMessage rtnMsg = new RtnMessage();
		
		Example roleExample = new Example(Role.class);
		roleExample.createCriteria()
				.andEqualTo("name", "商户")
				.andEqualTo("platform", "商户认证平台");
		List<Role> roleLst = roleMapper.selectByExample(roleExample);
		if(roleLst != null && !roleLst.isEmpty()) {
			Role role = roleLst.get(0);
			
			Example example = new Example(SvcUser.class);
			example.createCriteria()
					.andEqualTo("user_tel",merchantUser.getUserTel());
			if(merchantUserMapper.selectCountByExample(example) != 0) {
				rtnMsg.setIsSuccess(false);
				rtnMsg.setMessage(RtnMessage.ERROR_REGISTER_1);
			} else {
				merchantUser.setUserId(StringUtil.getUUID());
				merchantUser.setCreateDate(new Date());
                merchantUser.setRoleId(role.getRecId());

                merchantUserMapper.insert(merchantUser);
            }
		} else {
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage("注册错误:还未配置商户角色信息，无法注册商户");
		}
		
		
		return rtnMsg;
	}
	
	public MerchantUser queryMerchanteUser(MerchantUser merchantUser) {
		Example example = new Example(SvcUser.class);
		example.createCriteria()
				.andEqualTo("user_id",merchantUser.getUserId())
				.andEqualTo("status",CommonDictionary.TSvcUser.STATUS_NORMAL);
		
		List<MerchantUser> merchantUserLst = merchantUserMapper.selectByExample(example);
		if(merchantUserLst != null && merchantUserLst.size() > 0) {
			return merchantUserLst.get(0);
		}
		return null;
	}

	//TODO
	public RtnMessage createSvcUser(MerchantUser merchantUser) {
		return null;
	}

	//TODO
	public void doUpdateMerchantUser(MerchantUser merchantUser) {
		
	}

	//TODO
	public void deleteMerchantUser(String userId) {
		
	}
}
