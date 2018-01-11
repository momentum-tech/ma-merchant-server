package com.mmnttech.ma.merchant.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmnttech.ma.merchant.server.common.entity.QueryEntity;
import com.mmnttech.ma.merchant.server.common.entity.RtnMessage;
import com.mmnttech.ma.merchant.server.common.entity.UploadFileEntity;
import com.mmnttech.ma.merchant.server.service.StaticFileService;
import com.mmnttech.ma.merchant.server.util.CommonUtil;

/**
 * @类名 UploadFileController
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 easepay
 * @创建人 James
 * @创建时间 2018年1月4日 上午10:06:26
 * @版本 v1.0
 * 
 */
@Controller
public class UploadFileController {
	
	@Autowired
	private StaticFileService staticFileService;
	
	@ResponseBody
	@RequestMapping(value = "uploadFile")
	public RtnMessage uploadFile(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("QueryEntity") QueryEntity queryEntity) {
		RtnMessage rtn = new RtnMessage();
		String datas = request.getParameter("datas");
		if(datas != null) {
			int base64Idx = datas.indexOf("base64");
			if(datas.startsWith("data:") && datas.indexOf("base64") > 0) {
				String fileInfo = datas.substring(0, base64Idx - 1);
				String fileDatas = datas.substring(base64Idx + 7);
				
				int colonIdx = fileInfo.indexOf(":");
				int underlineIdx = fileInfo.indexOf("/");
				if(colonIdx > 0) {
					String fileType = fileInfo.substring(colonIdx + 1, underlineIdx);
					String fileFormat = fileInfo.substring(underlineIdx + 1, fileInfo.length());
					
					if("image".equals(fileType)) {
						byte[] fileByteInfos = CommonUtil.base64Decode(fileDatas.getBytes());
						staticFileService.storeImageFile(fileByteInfos, fileFormat);
					}
				}
			}
		} else {
			rtn.setIsSuccess(false);
			rtn.setMessage("上传数据异常，请检测上传文件");
		}
		return rtn;
	}
	
	@ResponseBody
	@RequestMapping(value = "uploadSliceFileHead")
	public UploadFileEntity uploadSliceFileHead(HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute("uploadFileEntity") UploadFileEntity uploadFileEntity) {
		if(uploadFileEntity.getData() != null) {
			String data = uploadFileEntity.getData();
			
			int base64Idx = data.indexOf("base64");
			if(data.startsWith("data:") && data.indexOf("base64") > 0) {
				String fileInfo = data.substring(0, base64Idx - 1);
				String fileDatas = data.substring(base64Idx + 7);
				
				int colonIdx = fileInfo.indexOf(":");
				int underlineIdx = fileInfo.indexOf("/");
				if(colonIdx > 0) {
					String fileType = fileInfo.substring(colonIdx + 1, underlineIdx);
					String fileFormat = fileInfo.substring(underlineIdx + 1, fileInfo.length());
					
					if("image".equals(fileType)) {
						uploadFileEntity = staticFileService.storeSliceFileHead(fileDatas.getBytes(), fileFormat);
					}
				}
			}
		} else {
			uploadFileEntity.setIsSuccess(false);
			uploadFileEntity.setMessage("上传数据异常，请检测上传文件");
		}
		return uploadFileEntity;
	}
	
	@ResponseBody
	@RequestMapping(value = "uploadSliceFile")
	public UploadFileEntity uploadSliceFile(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("uploadFileEntity") UploadFileEntity uploadFileEntity) {
		String datas = uploadFileEntity.getData();
		String fileFullPath = uploadFileEntity.getFullFilePath();
		String relativeFilePath = uploadFileEntity.getRelativeFilePath();
		
		boolean isLast = uploadFileEntity.getIsLast();
		if(datas != null && fileFullPath != null && relativeFilePath != null) {
			RtnMessage rtnMessage = staticFileService.storeSliceFile(datas, fileFullPath);
			
			if(rtnMessage.getIsSuccess()) {
				if(isLast) {
					uploadFileEntity = staticFileService.mergeSliceFile(uploadFileEntity);
				}
			}
		}
		return uploadFileEntity;
	}
	
	
	
	
}
