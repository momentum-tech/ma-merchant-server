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
 * @类名 DivisionController
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月11日 下午9:05:55
 * @版本 v1.0
 * 
 */

@Controller
public class DivisionController {
	
	private Logger logger = LoggerFactory.getLogger(DivisionController.class);
	
	private static final int LOCATION_LEVEL_ONE = 1;
	private static final int LOCATION_LEVEL_TWO = 2;
	private static final int LOCATION_LEVEL_THREE = 3;

	@Autowired
	private JedisPool jedisPool;
	
	@ResponseBody
	@RequestMapping(value = "getDivisionInfo")
	public RtnMessage getDivisionInfo(HttpServletRequest request, HttpServletResponse response) {
		RtnMessage rtnMsg = new RtnMessage();
		Jedis jedis = null;
		try {
			String level = request.getParameter("level");
			String fNode = request.getParameter("fNode");
			
			if(level != null) {
				int levelIntValue = Integer.parseInt(level);
				
				List<Map<String, String>> divLst = new ArrayList<Map<String, String>>();
				
				jedis = jedisPool.getResource();
				List<String> divisionlst = null;

				switch(levelIntValue) {
				case LOCATION_LEVEL_ONE:
					divisionlst = jedis.lrange("division00", 0, -1);
					break;
				case LOCATION_LEVEL_TWO:
					divisionlst = jedis.lrange("division" + fNode, 0, -1);
					break;
				case LOCATION_LEVEL_THREE:
					divisionlst = jedis.lrange("division" + fNode, 0, -1);
					break;
				}
				
				if(divisionlst != null) {
					for(String divisionInfo : divisionlst) {
						if(divisionInfo != null && divisionInfo.indexOf("|") > 0) {
							String[] divisionInfos = divisionInfo.split("\\|");
							if(divisionInfos != null && divisionInfos.length > 1) {
								Map<String, String> divisionMap = new HashMap<String, String>();
								divisionMap.put("div_code", divisionInfos[0]);
								divisionMap.put("div_name", divisionInfos[1]);
								divisionMap.put("div_level", String.valueOf(levelIntValue + 1));
								
								divLst.add(divisionMap);
							}
						}
					}
					rtnMsg.setRtnObj(divLst);
				}
			}
		} catch(Exception e) {
			logger.error("获取区域错误" + e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage("获取区域信息失败");
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
		return rtnMsg;
	}
	
}
