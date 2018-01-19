package com.mmnttech.ma.merchant.server.service;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mmnttech.ma.merchant.server.common.entity.RtnMessage;
import com.mmnttech.ma.merchant.server.common.entity.StaticFileEntity;
import com.mmnttech.ma.merchant.server.common.entity.UploadFileEntity;
import com.mmnttech.ma.merchant.server.util.CommonUtil;
import com.mmnttech.ma.merchant.server.util.ImageHelper;
import com.mmnttech.ma.merchant.server.util.StringUtil;

/**
 * @类名 StaticFileService
 * @描述:
 * @版权: Copyright (c) 2017 doughbbs
 * @创建人 James
 * @创建时间 2017年10月17日 下午2:15:55
 * @版本 v1.0
 * 
 */
@Service("staticFileService")
public class StaticFileService {
	
//	private String rootPath = "d:\\Pictures";
	
	private String rootPath = "/home/ubuntu/staticres/images";
	
	public static final String STATIC_IMAGE_PATH = "http://111.231.201.90/images/";
	
	private static final int miniWidth = 600;
	private static final int miniHeight = 600;
	
	private Logger logger = LoggerFactory.getLogger(StaticFileService.class);
	
	public UploadFileEntity storeSliceFileHead(byte[] fileInfos, String fileFormat) {
		UploadFileEntity uploadFileEntity = new UploadFileEntity();
		
		StringBuffer fileName = new StringBuffer();
		fileName.append(StringUtil.getUUID().substring(0, 8)).append(".").append(fileFormat).append(".TMP");
		
		FileOutputStream fos = null;
		try {
			StaticFileEntity staticFileEntity = checkFileFolder();
			
			String fileFullPath = staticFileEntity.getFileNamePre() + File.separator + fileName;
			String relativeFilePath = staticFileEntity.getFileRelativePrefixStr() + File.separator + fileName;
			
			fos = new FileOutputStream(new File(fileFullPath));
			fos.write(fileInfos);
			
			uploadFileEntity.setFullFilePath(fileFullPath);
			uploadFileEntity.setRelativeFilePath(relativeFilePath);
		} catch(Exception e) {
			logger.error("storeImageHead 异常：", e);
			uploadFileEntity.setMessage("storeImageHead 异常");
			uploadFileEntity.setIsSuccess(false);
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException ioException) {
				logger.error("关闭IO异常：", ioException);
			}
		}
		return uploadFileEntity;
	}
	
	public RtnMessage storeSliceFile(String fileData, String fileFullPath) {
		RtnMessage rtnMessage = new RtnMessage();
		
		BufferedWriter br = null;
		try {
			br = new BufferedWriter(new FileWriter(fileFullPath, true));
			br.append(fileData);
			br.flush();
		} catch (Exception e) {
			rtnMessage.setIsSuccess(false);
			rtnMessage.setMessage("保存文件异常");
			logger.error("保存文件异常:", e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				logger.error("关闭IO异常", e);
			}
		}
		return rtnMessage;
	}
	
	public UploadFileEntity mergeSliceFile(UploadFileEntity uploadFileEntity) {
		BufferedInputStream bis = null;
		byte[] fileByteInfos = null;
		try {
			String fileFullPath = uploadFileEntity.getFullFilePath();
			
			bis = new BufferedInputStream(new FileInputStream(new File(fileFullPath)));
			byte[] fileDataInfos = new byte[bis.available()];
			bis.read(fileDataInfos);
			
			fileByteInfos = CommonUtil.base64Decode(fileDataInfos);
		} catch (Exception e) {
			logger.error("关闭IO异常", e);
			uploadFileEntity.setIsSuccess(false);
			uploadFileEntity.setMessage("关闭IO异常");
		} finally {
			try {
				bis.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		if(fileByteInfos != null) {
			InputStream fileInputStream = null;
			
			try {
				String fileFullPath = uploadFileEntity.getFullFilePath();
				String relativeFilePath = uploadFileEntity.getRelativeFilePath();
				
				uploadFileEntity.setFullFilePath(fileFullPath.substring(0, fileFullPath.indexOf(".TMP")) + ".STB");
				uploadFileEntity.setRelativeFilePath(relativeFilePath.substring(0, relativeFilePath.indexOf(".TMP")));
				
				fileInputStream = new ByteArrayInputStream(fileByteInfos);
				ImageHelper.scaleImage(fileInputStream, uploadFileEntity.getFullFilePath(), miniWidth, miniHeight);
				
				new File(fileFullPath).delete();
			} catch (Exception e) {
				logger.error("关闭IO异常", e);
			} finally {
				try {
					fileInputStream.close();
				} catch (IOException e1) {
					logger.error("关闭IO异常", e1);
				}
			}
		}
		return uploadFileEntity;
	}
	
	public void changeFile2Normal(String fileFullPath) throws Exception {
		if(fileFullPath.endsWith(".STB")) {
			File file = new File(fileFullPath);
			file.renameTo(new File(fileFullPath.substring(0, fileFullPath.length() - 4)));
		}
	}
	
	public String getNormalRelativePathName(String fileRelativePath) {
		return fileRelativePath.substring(0, fileRelativePath.length() - 4);
	}
	
	public String storeImageFile(byte[] fileInfos, String fileFormat) {
		try {
			StringBuffer fileName = new StringBuffer();
			fileName.append(StringUtil.getUUID().substring(0, 8)).append(".").append("T").append(".").append(fileFormat);
			
			FileOutputStream fos = null;
			FileInputStream fis = null;
			
			InputStream imageInputStream = null;
			
			try {
				imageInputStream = new ByteArrayInputStream(fileInfos);
				
				StaticFileEntity staticFileEntity = checkFileFolder();
				
				String imageFullName = staticFileEntity.getFileNamePre() + File.separator + fileName;
				String imageRelativePath = staticFileEntity.getFileRelativePrefixStr() + File.separator + fileName;
				
				ImageHelper.scaleImage(imageInputStream, imageFullName, miniWidth, miniHeight);
				return imageRelativePath;
			} finally {
				try {
					if (fos != null) {
						fos.close();
					}
					if(fis != null) {
						fis.close();
					}
				} catch (IOException ioException) {
					logger.error("关闭IO异常：", ioException);
				}
			}
		} catch (Exception e) {
			logger.error("storeStaticImageFile 异常：", e);
		}
		return null;
	}
	
	
	public String storeStaticImageFile(InputStream fileIS) {
		try {
			String fileName = StringUtil.getUUID().substring(0, 8) + ".png";
			
			FileOutputStream fos = null;
			FileInputStream fis = null;
			
			try {
				StaticFileEntity staticFileEntity = checkFileFolder();
				
				String imageFullName = staticFileEntity.getFileNamePre() + File.separator + fileName;
				String imageRelativePath = staticFileEntity.getFileRelativePrefixStr() + File.separator + fileName;;
				
				ImageHelper.scaleImage(fileIS, imageFullName, miniWidth, miniHeight);
				return imageRelativePath;
			} finally {
				try {
					if (fos != null) {
						fos.close();
					}
					if(fis != null) {
						fis.close();
					}
				} catch (IOException ioException) {
					logger.error("关闭IO异常：", ioException);
				}
			}
		} catch (Exception e) {
			logger.error("storeStaticImageFile 异常：", e);
		}
		return null;
	}
	
	private void createFileFolderIfNotExist(String filePath) throws Exception {
		File folder = new File(filePath.toString());
		if (!folder.exists() && !folder.isDirectory()) {
			folder.mkdir();
		}
	}
	
	private StaticFileEntity checkFileFolder() {
		StaticFileEntity staticFileEntity = new StaticFileEntity();
		try {
			Calendar cal = Calendar.getInstance();
			
			StringBuffer fileNamePre = new StringBuffer();
			StringBuffer fileRelativePrefixStr = new StringBuffer();
			
			fileNamePre.append(rootPath).append(File.separator).append(cal.get(Calendar.YEAR));
			createFileFolderIfNotExist(fileNamePre.toString());
			
			fileNamePre.append(File.separator).append(cal.get(Calendar.MONTH) + 1);
			createFileFolderIfNotExist(fileNamePre.toString());
			
			fileNamePre.append(File.separator).append(cal.get(Calendar.DATE));
			createFileFolderIfNotExist(fileNamePre.toString());
			
			fileRelativePrefixStr.append(cal.get(Calendar.YEAR));
			fileRelativePrefixStr.append(File.separator).append(cal.get(Calendar.MONTH) + 1);
			fileRelativePrefixStr.append(File.separator).append(cal.get(Calendar.DATE));
			
			staticFileEntity.setFileNamePre(fileNamePre.toString());
			staticFileEntity.setFileRelativePrefixStr(fileRelativePrefixStr.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staticFileEntity;
	}
	
	public RtnMessage deleteFileByRelativePath(String fileRelativePath) {
		RtnMessage rtnMsg = new RtnMessage();
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append(rootPath).append(File.separator).append(fileRelativePath);
			
			File file = new File(buffer.toString());
			file.delete();
		} catch (Exception e) {
			logger.error("删除商品图片失败: deleteFileByRelativePath", e);
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage("删除商品图片失败: 请稍后再试");
		}
		return rtnMsg;
	}
	
	public void getFileStaticPath(Map<String, Object> map, String key) {
		if(map.get(key) != null) {
			String relativePath = map.get(key).toString();
			
			map.put(key, StaticFileService.STATIC_IMAGE_PATH + relativePath);
		}
	}
	
	
}
