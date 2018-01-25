package com.mmnttech.ma.merchant.server.controller;

import com.mmnttech.ma.merchant.server.common.dto.MerchantDto;
import com.mmnttech.ma.merchant.server.common.entity.RtnMessage;
import com.mmnttech.ma.merchant.server.model.Merchant;
import com.mmnttech.ma.merchant.server.service.AttachService;
import com.mmnttech.ma.merchant.server.service.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @类名 MerchantController
 * @描述: 用于商户注册，登录，密码修改，详细信息管理
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月6日 下午5:01:47
 * @版本 v1.0
 * 
 */

@RestController
@RequestMapping(value = "/v1/merchants")
public class MerchantController {

	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private AttachService attachService;

	private Logger logger = LoggerFactory.getLogger(MerchantController.class);


    //TODO:待确认
    //获取商户详细信息
    @RequestMapping(value = "/queryMerchantInfo")
    public RtnMessage queryMerchantInfo(HttpServletRequest request, HttpServletResponse response,
                                        @ModelAttribute("merchant") Merchant merchant) {
        RtnMessage rtnMsg = new RtnMessage();
        try {
            Map<String, Object> merchantInfo = merchantService.queryMerchantById(merchant.getRecId());
//			List<Attach> attachLst = attachService.findByMasterId(merchant.getRecId());
//			for(Attach attach : attachLst) {
//				if(attach.getType().equals(DictionaryConst.AttachType.ID_FRONT_IMAGE.getValue())) {
//					merchantInfo.put("idCardFrontUrl", StaticFileService.STATIC_IMAGE_PATH + attach.getAttachUrl());
//				} else if(attach.getType().equals(DictionaryConst.AttachType.ID_BACK_IMAGE.getValue())) {
//					merchantInfo.put("idCardBackUrl", StaticFileService.STATIC_IMAGE_PATH + attach.getAttachUrl());
//				} else if(attach.getType().equals(DictionaryConst.AttachType.MERCHANT_LICENSE_IMAGE.getValue())) {
//					merchantInfo.put("licenseNoUrl", StaticFileService.STATIC_IMAGE_PATH + attach.getAttachUrl());
//				} else if(attach.getType().equals(DictionaryConst.AttachType.MERCHANT_QR.getValue())) {
//					merchantInfo.put("merchantQRImage", StaticFileService.STATIC_IMAGE_PATH + attach.getAttachUrl());
//				}
//			}
            rtnMsg.setRtnObj(merchantInfo);
        } catch (Exception e) {
            logger.error("queryMerchantInfo 出现异常：", e);
            rtnMsg.setIsSuccess(false);
            rtnMsg.setMessage(RtnMessage.ERROR_QUERY_1);
        }

        return rtnMsg;
    }


	//商户审核过程查询
    @RequestMapping(value = "/queryProgressInfo")
    public RtnMessage queryProgressInfo(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("merchant") Merchant merchant) {
		RtnMessage rtnMsg = new RtnMessage();

		try {
			//TODO
			
		} catch (Exception e) {
			logger.error("queryProgressInfo 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage("商户审核过程查询异常：请稍后再试");
		}
		
		return rtnMsg;
	}
	
	//获取商户诚信二维码信息
    @RequestMapping(value = "/queryMerchantQRImage")
    public RtnMessage queryMerchantQRImage(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("merchant") Merchant merchant) {
		RtnMessage rtnMsg = new RtnMessage();

		try {
			//TODO
			
		} catch (Exception e) {
			logger.error("queryMerchantQRImage 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage("获取商户诚信二维码信息：请稍后再试");
		}
		
		return rtnMsg;
	}

    @RequestMapping(method = RequestMethod.POST, value = "/postmerchantinfo")
    public RtnMessage postCertification(@RequestBody MerchantDto merchantDto) {
        RtnMessage rtnMessage = new RtnMessage();
        try {
			rtnMessage.setRtnObj(merchantService.createMerchant(merchantDto));
			rtnMessage.setIsSuccess(true);
        } catch (Exception e) {
            logger.error("postCertification出现异常:", e);
            rtnMessage.setIsSuccess(false);
            rtnMessage.setMessage("提交诚信商户认证信息失败，请稍后再试");
        }
        return rtnMessage;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/querymerchantinfo")
    public RtnMessage findCertification(@RequestParam String key) {
        RtnMessage rtnMessage = new RtnMessage();
		try {
            rtnMessage.setRtnObj(merchantService.queryMerchantDetailInfoById(key));
            rtnMessage.setIsSuccess(true);
		} catch (Exception e) {
			logger.error("findCertification出现异常:", e);
			rtnMessage.setIsSuccess(false);
			rtnMessage.setMessage("查询诚信商户认证信息失败，请稍后再试");
		}
		return rtnMessage;
	}
}
