package com.mmnttech.ma.merchant.server.entity;

import com.mmnttech.ma.merchant.server.model.Merchant;

/**
 * @类名 MerchantUserAuth
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月15日 上午10:24:51
 * @版本 v1.0
 * 
 */
public class MerchantAuth extends Merchant {

	private String idCardFrontUrl;
	
	private String idCardFrontFullPath;
	
	private String idCardBackUrl;
	
	private String idCardBackFullPath;
	
	private String licenseNoUrl;
	
	private String licenseNoFullPath;

	public String getIdCardFrontUrl() {
		return idCardFrontUrl;
	}

	public void setIdCardFrontUrl(String idCardFrontUrl) {
		this.idCardFrontUrl = idCardFrontUrl;
	}

	public String getIdCardFrontFullPath() {
		return idCardFrontFullPath;
	}

	public void setIdCardFrontFullPath(String idCardFrontFullPath) {
		this.idCardFrontFullPath = idCardFrontFullPath;
	}

	public String getIdCardBackUrl() {
		return idCardBackUrl;
	}

	public void setIdCardBackUrl(String idCardBackUrl) {
		this.idCardBackUrl = idCardBackUrl;
	}

	public String getIdCardBackFullPath() {
		return idCardBackFullPath;
	}

	public void setIdCardBackFullPath(String idCardBackFullPath) {
		this.idCardBackFullPath = idCardBackFullPath;
	}

	public String getLicenseNoUrl() {
		return licenseNoUrl;
	}

	public void setLicenseNoUrl(String licenseNoUrl) {
		this.licenseNoUrl = licenseNoUrl;
	}

	public String getLicenseNoFullPath() {
		return licenseNoFullPath;
	}

	public void setLicenseNoFullPath(String licenseNoFullPath) {
		this.licenseNoFullPath = licenseNoFullPath;
	}
}
