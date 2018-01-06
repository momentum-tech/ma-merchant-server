package com.mmnttech.ma.merchant.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mmnttech.ma.merchant.server.service.MerchantService;

/**
 * @类名 MerchantController
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月6日 下午5:01:47
 * @版本 v1.0
 * 
 */

@Controller
public class MerchantController {

	@Autowired
	private MerchantService merchantService;
	
}
