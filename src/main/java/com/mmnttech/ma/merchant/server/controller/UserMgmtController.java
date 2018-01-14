package com.mmnttech.ma.merchant.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmnttech.ma.merchant.server.common.entity.RtnMessage;
import com.mmnttech.ma.merchant.server.common.entity.TreeMenuItem;
import com.mmnttech.ma.merchant.server.model.Merchant;
import com.mmnttech.ma.merchant.server.model.MerchantUser;
import com.mmnttech.ma.merchant.server.model.Role;
import com.mmnttech.ma.merchant.server.model.SvcUser;
import com.mmnttech.ma.merchant.server.service.MerchantService;
import com.mmnttech.ma.merchant.server.service.MerchantUserService;
import com.mmnttech.ma.merchant.server.service.RoleService;
import com.mmnttech.ma.merchant.server.service.SvcUserMgmtService;

/**
 * @类名 UserMgmtController
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月9日 上午10:12:21
 * @版本 v1.0
 * 
 */
@Controller
public class UserMgmtController {

	private Logger logger = LoggerFactory.getLogger(UserMgmtController.class);
	
	@Autowired
	private SvcUserMgmtService svcUserMgmtService;
	
	@Autowired
	private MerchantUserService merchantUserService;
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private RoleService roleService;
	
	//用于查询用户基础信息，之后也可以用于用户的鉴权
	@ResponseBody
	@RequestMapping(value = "queryUserBaseInfo")
	public RtnMessage queryUserBaseInfo(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("merchantUser") MerchantUser merchantUser) {
		RtnMessage rtnMsg = new RtnMessage();
		try {
			MerchantUser record = merchantUserService.queryMerchanteUser(merchantUser);
			if(record != null) {
				Role role = roleService.queryMerchanteRoleInfo();
				Merchant merchant = merchantService.queryMerchantById(record.getMerchantId());
				
				String treeNodeId = request.getParameter("treeNodeId");
				
				Map<String, Object> userBaseInfo = new HashMap<String, Object>();
				
				List<TreeMenuItem> datas = svcUserMgmtService.queryUserTreeMenuItem(role.getRecId(), treeNodeId, merchant.getComStat());
				userBaseInfo.put("menuInfo", datas);
				userBaseInfo.put("roleInfo", role.getName() + "(" + role.getPlatform() + ")");
				
				rtnMsg.setRtnObj(userBaseInfo);
			} else {
				rtnMsg.setIsSuccess(false);
				rtnMsg.setMessage("获取用户信息失败，您的用户不可用或提供的信息不正确，请联系客服人员");
			}
		} catch (Exception e) {
			logger.error("queryUserBaseInfo 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage(RtnMessage.ERROR_QUERY_1);
		}
		return rtnMsg;
	}
	
	@ResponseBody
	@RequestMapping(value = "queryUserInfo")
	public RtnMessage queryUserInfo(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") SvcUser svcUser) {
		RtnMessage rtnMsg = new RtnMessage();
		try {
			SvcUser record = svcUserMgmtService.querySvcUser(svcUser);
			if(record != null) {
				rtnMsg.setRtnObj(record);
			} else {
				rtnMsg.setIsSuccess(false);
				rtnMsg.setMessage("获取用户信息失败，您的用户不可用或提供的信息不正确，请联系客服人员");
			}
		} catch (Exception e) {
			logger.error("queryUserInfo 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage(RtnMessage.ERROR_QUERY_1);
		}
		return rtnMsg;
	}
	
	
	
}
