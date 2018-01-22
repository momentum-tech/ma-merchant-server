package com.mmnttech.ma.merchant.server.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmnttech.ma.merchant.server.common.entity.DictionaryConst;
import com.mmnttech.ma.merchant.server.common.entity.RtnMessage;
import com.mmnttech.ma.merchant.server.entity.MerchantAuth;
import com.mmnttech.ma.merchant.server.model.Attach;
import com.mmnttech.ma.merchant.server.model.Merchant;
import com.mmnttech.ma.merchant.server.model.MerchantUser;
import com.mmnttech.ma.merchant.server.service.MerchantService;
import com.mmnttech.ma.merchant.server.service.MerchantUserService;
import com.mmnttech.ma.merchant.server.service.RoleService;
import com.mmnttech.ma.merchant.server.service.StaticFileService;

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
@RequestMapping(value = "/v1/merchantUser/")
public class MerchantUserController {
	
	private Logger logger = LoggerFactory.getLogger(MerchantUserController.class);
	
	@Autowired
	private MerchantUserService merchantUserService;
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private StaticFileService staticFileService;
	
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
			logger.error("doRegists 出现异常：", e);
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
			logger.error("createMerchantUser 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage(RtnMessage.ERROR_REGISTER_2);
		}
		return rtnMsg;
	}
	

	
	//商户密码修改
	@ResponseBody
    @RequestMapping(value = "passwd")
    public RtnMessage passwd(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("merchant") Merchant merchant) {
		RtnMessage rtnMsg = new RtnMessage();
		
		try {
			//TODO
			
		} catch (Exception e) {
			logger.error("passwd 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage("修改密码异常：请稍后再试");
		}
		
		return rtnMsg;
	}
	
	@ResponseBody
	@RequestMapping(value = "merchantAuth")
	public RtnMessage merchantAuth(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("merchantAuth") MerchantAuth merchantAuth) {
		RtnMessage rtnMsg = new RtnMessage();
		try {
			List<Attach> attachLst = new ArrayList<Attach>();
			if(merchantAuth.getIdCardFrontFullPath() != null && merchantAuth.getIdCardFrontUrl() != null) {
				staticFileService.changeFile2Normal(merchantAuth.getIdCardFrontFullPath());
				
				Attach idCardFront = new Attach();
				idCardFront.setType(DictionaryConst.TAttach.TYPE_ID_FRONT_IMAGE);
				idCardFront.setName("商户法人身份证(正面)");
				idCardFront.setSeriNo(1);
				idCardFront.setAttachUrl(merchantAuth.getIdCardBackUrl());
				
				attachLst.add(idCardFront);
			}
			
			if(merchantAuth.getIdCardBackFullPath() != null && merchantAuth.getIdCardBackUrl() != null) {
				staticFileService.changeFile2Normal(merchantAuth.getIdCardBackFullPath());
				
				Attach idCardBack = new Attach();
				idCardBack.setType(DictionaryConst.TAttach.TYPE_ID_BACK_IMAGE);
				idCardBack.setName("商户法人身份证(反面)");
				idCardBack.setSeriNo(2);
				idCardBack.setAttachUrl(merchantAuth.getIdCardBackUrl());
				
				attachLst.add(idCardBack);
			}

			if(merchantAuth.getLicenseNoFullPath() != null && merchantAuth.getLicenseNoUrl() != null) {
				staticFileService.changeFile2Normal(merchantAuth.getLicenseNoFullPath());
				
				Attach license = new Attach();
				license.setType(DictionaryConst.TAttach.TYPE_MERCHANT_LICENSE_IMAGE);
				license.setName("商户营业执照");
				license.setSeriNo(3);
				license.setAttachUrl(merchantAuth.getIdCardBackUrl());
				
				attachLst.add(license);
			}
			
			merchantService.txMerchantAuth(merchantAuth, attachLst);
		} catch (Exception e) {
			logger.error("doUpdateMerchantUser 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage(RtnMessage.ERROR_UPDATE_1);
		}
		return rtnMsg;
	}


}
