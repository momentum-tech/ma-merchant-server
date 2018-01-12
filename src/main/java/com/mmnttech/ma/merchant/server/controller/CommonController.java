package com.mmnttech.ma.merchant.server.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.mmnttech.ma.merchant.server.common.entity.RtnMessage;

/**
 * @类名 CommonController
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月12日 下午3:32:44
 * @版本 v1.0
 * 
 */
@Controller
public class CommonController {

	private Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private JedisPool jedisPool;

	@ResponseBody
	@RequestMapping(value = "queryIndustyInfos")
	public RtnMessage queryIndustyInfos(HttpServletRequest request, HttpServletResponse response) {
		RtnMessage rtnMsg = new RtnMessage();
		List<Map<String, String>> records = new ArrayList<Map<String, String>>();
		
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			
			List<String> valueLst = jedis.lrange("industy", 0, -1);
			for(String value : valueLst) {
				if(value.indexOf("|") > 0) {
					String[] industryLst = value.split("\\|");
					Map<String, String> industry = new HashMap<String, String>();
					industry.put("code", industryLst[0]);
					industry.put("name", industryLst[1]);
					
					records.add(industry);
				}
			}
			rtnMsg.setRtnObj(records);
		} catch(Exception e) {
			logger.error("获取区域错误" + e);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
		
		return rtnMsg;
	}
	
	@ResponseBody
	@RequestMapping(value = "queryCategoryInfos")
	public RtnMessage queryCategoryInfos(HttpServletRequest request, HttpServletResponse response) {
		RtnMessage rtnMsg = new RtnMessage();
		
		String industryCode = request.getParameter("industryCode");
		if(industryCode != null) {
			List<Map<String, String>> records = new ArrayList<Map<String, String>>();
			
			Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();
				
				List<String> valueLst = jedis.lrange("category" + industryCode, 0, -1);
				for(String value : valueLst) {
					if(value.indexOf("|") > 0) {
						String[] industryLst = value.split("\\|");
						Map<String, String> industry = new HashMap<String, String>();
						industry.put("code", industryLst[0]);
						industry.put("name", industryLst[1]);
						
						records.add(industry);
					}
				}
				
				rtnMsg.setRtnObj(records);
			} catch(Exception e) {
				logger.error("获取区域错误" + e);
			} finally {
				if(jedis != null) {
					jedis.close();
				}
			}
		}
		return rtnMsg;
	}
	
}
