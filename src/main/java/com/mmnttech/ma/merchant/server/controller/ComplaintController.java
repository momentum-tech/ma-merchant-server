package com.mmnttech.ma.merchant.server.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmnttech.ma.merchant.server.common.entity.QueryEntity;
import com.mmnttech.ma.merchant.server.common.entity.RtnMessage;
import com.mmnttech.ma.merchant.server.model.Complaint;
import com.mmnttech.ma.merchant.server.service.ComplaintService;

/**
 * @类名 ComplaintController
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月6日 下午5:05:24
 * @版本 v1.0
 * 
 */

@RestController
@RequestMapping(value = "/v1/complaints")
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;

	private Logger logger = LoggerFactory.getLogger(ComplaintController.class);
	
	//商户投诉查询
	@RequestMapping(value = "queryComplaintInfos")
	public RtnMessage queryComplaintInfos(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("queryEntity") QueryEntity queryEntity) {
		RtnMessage rtnMsg = new RtnMessage();
		try {
			List<Map<String, Object>> complaintLst = complaintService.queryComplaintByMerchantId(queryEntity.getMerchId(), queryEntity.getPage(), queryEntity.getRows());
			rtnMsg.setRtnObj(complaintLst);
		} catch (Exception e) {
			logger.error("queryComplaintInfos 出现异常：", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage("商户投诉查询：请稍后再试");
		}
		
		return rtnMsg;
	}

    @RequestMapping(method = RequestMethod.GET)
    public RtnMessage queryComplaintInfoByRecId(@ModelAttribute("queryEntity") QueryEntity queryEntity) {
        RtnMessage rtnMessage = new RtnMessage();
        try {
            String recId = queryEntity.getRecId();
            String merchantId = queryEntity.getMerchId();
            String merchantName = queryEntity.getMerchName();
            int page = queryEntity.getPage();
            int size = queryEntity.getRows();
            if (recId != null && recId != "") {
                rtnMessage.setRtnObj(complaintService.queryComplaintByRecId(recId));
            } else if (merchantId != null && merchantId != "") {
                rtnMessage.setRtnObj(complaintService.queryComplaintByMerchantId(merchantId, page, size));
            } else if (merchantName != null && merchantName != "") {
                rtnMessage.setRtnObj(complaintService.queryComplaintByMerchantName(merchantName, page, size));
            } else {
                rtnMessage.setIsSuccess(false);
                rtnMessage.setMessage("商户投诉查询：参数错误");
            }
        } catch (Exception e) {
            logger.error("queryComplaintInfoByRecId 出现异常");
            rtnMessage.setIsSuccess(false);
            rtnMessage.setMessage("商户投诉查询：请稍后再试");
        }
        return rtnMessage;
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public RtnMessage queryComplaintInfoByAnyCondition(@RequestBody Complaint complaint, @RequestParam("page") int page, @RequestParam("size") int size) {
        RtnMessage rtnMessage = new RtnMessage();
        try {
            complaintService.queryComplaintByAnyCondition(complaint, page, size);
        } catch (Exception e) {
            logger.error("queryComplaintInfoByRecId 出现异常");
            rtnMessage.setIsSuccess(false);
            rtnMessage.setMessage("商户投诉查询：请稍后再试");
        }
        return rtnMessage;
    }

}
