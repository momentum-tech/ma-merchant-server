package com.mmnttech.ma.merchant.server.common.entity;

/**
 * @类名 CommonDictionary
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月8日 上午10:02:46
 * @版本 v1.0
 * 
 */
public class DictionaryConst {

	public class Common {
		public static final String PAYNAME_WEIX = "weix";
		public static final String PAYNAME_ALIPAY = "alipay";
		
		public static final String STAT_UNAUTHORIZED = "0";
		public static final String STAT_WAITING_4_AUTHORIZETION = "1";
		public static final String STAT_ONLINE_AUTHORIZETION = "2";
		public static final String STAT_OFFLINE_AUTHORIZETION = "3";
		public static final String STAT_AUTHORIZETION_FAILUE = "4";
		
		
		public static final String TYPE_NORMAL = "normal";
		public static final String TYPE_CHECK = "check";
		
		public static final String STAT_DISABLE = "0";
		public static final String STAT_ENABLE = "1";
		
		public static final String COM_STAT_UNAUTHORIZED = "0";
		public static final String COM_STAT_WAITING_4_AUTHORIZETION = "1";
		public static final String COM_STAT_AUTHORIZETION_PASS = "2";
		public static final String COM_STAT_AUTHORIZETION_DENY = "3";
	}
	
	public class TSvcUser {
		public static final String STATUS_NORMAL = "1";
		public static final String STATUS_DISABLE = "2";
		
		public static final String ROLE_INFO_ADMINISTRATOR = "1";
		public static final String ROLE_INFO_OPERATRO = "2";
	}
	
	public class TMerchant {
		public static final String AUTH_STEP_1 = "1";
		public static final String AUTH_STEP_2 = "2";
		public static final String AUTH_STEP_3 = "3";
	}
	
	public class TAttach {
		public static final String TYPE_HEAD_IMAGE = "1";
		public static final String TYPE_ID_FRONT_IMAGE = "2";
		public static final String TYPE_ID_BACK_IMAGE = "3";
		public static final String TYPE_MERCHANT_LICENSE_IMAGE = "4";
	}
	
}
