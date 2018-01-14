package com.mmnttech.ma.merchant.server.controller;

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
import com.mmnttech.ma.merchant.server.model.MerchantUser;
import com.mmnttech.ma.merchant.server.service.MerchantUserService;
import com.mmnttech.ma.merchant.server.service.RoleService;

/**
 * @类名 MerchantUserController
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月14日 下午8:33:49
 * @版本 v1.0
 * 
 */
@Controller
public class MerchantUserController {
	
	private Logger logger = LoggerFactory.getLogger(MerchantUserController.class);
	
	@Autowired
	private MerchantUserService merchantUserService;
	
	@Autowired
	private RoleService roleService;
	
	@ResponseBody
	@RequestMapping(value = "doLogin")
	public RtnMessage doLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("merchantUser") MerchantUser merchantUser) {
		RtnMessage rtnMsg = new RtnMessage();
		try {
			rtnMsg = merchantUserService.doLogin(merchantUser);
		} catch (Exception e) {
			logger.error("doLogin 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage(RtnMessage.ERROR_LOGIN_2);
		}
		return rtnMsg;
	}

	@ResponseBody
	@RequestMapping(value = "doRegists")
	public RtnMessage doRegists(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("merchantUser") MerchantUser merchantUser) {
		RtnMessage rtnMsg = new RtnMessage();
		try {
			rtnMsg = merchantUserService.txRegists(merchantUser);
		} catch (Exception e) {
			logger.error("doLogin 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage(RtnMessage.ERROR_LOGIN_2);
		}
		return rtnMsg;
	}
	
	@ResponseBody
	@RequestMapping(value = "createMerchantUser")
	public RtnMessage createMerchantUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("merchantUser") MerchantUser merchantUser) {
		RtnMessage rtnMsg = new RtnMessage();
		try {
			rtnMsg = merchantUserService.createSvcUser(merchantUser);
		} catch (Exception e) {
			logger.error("createSvcUser 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage(RtnMessage.ERROR_REGISTER_2);
		}
		return rtnMsg;
	}
	
	@ResponseBody
	@RequestMapping(value = "doUpdateMerchantUser")
	public RtnMessage doUpdateSvcUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("merchantUser") MerchantUser merchantUser) {
		RtnMessage rtnMsg = new RtnMessage();
		try {
			merchantUserService.doUpdateMerchantUser(merchantUser);
		} catch (Exception e) {
			logger.error("doUpdateMerchantUser 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage(RtnMessage.ERROR_UPDATE_1);
		}
		return rtnMsg;
	}

	@ResponseBody
	@RequestMapping(value = "deleteMerchantUser")
	public RtnMessage deleteMerchantUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("merchantUser") MerchantUser merchantUser) {
		RtnMessage rtnMsg = new RtnMessage();
		try {
			merchantUserService.deleteMerchantUser(merchantUser.getUserId());
		} catch (Exception e) {
			logger.error("deleteMerchantUser 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage(RtnMessage.ERROR_DELETE_2);
		}
		return rtnMsg;
	}
	
	

}