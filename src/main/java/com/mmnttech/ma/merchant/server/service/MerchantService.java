package com.mmnttech.ma.merchant.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmnttech.ma.merchant.server.common.dto.MerchantDto;
import com.mmnttech.ma.merchant.server.common.exception.DatabaseException;
import com.mmnttech.ma.merchant.server.mapper.MerchantMapper;
import com.mmnttech.ma.merchant.server.model.Merchant;
import com.mmnttech.ma.merchant.server.util.StringUtil;

/**
 * @类名 MerchantService
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 云南动量科技有限公司
 * @创建人 James
 * @创建时间 2018年1月6日 下午5:07:34
 * @版本 v1.0
 * 
 */

@Transactional(rollbackFor = DatabaseException.class)
@Service("merchantService")
public class MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private AttachService attachService;
    
    public MerchantDto create(MerchantDto merchantDto) {
        Merchant merchant = merchantDto.getMerchant();
        merchant.setRecId(StringUtil.getUUID());
        if (merchantMapper.insert(merchant) == 1) {
            if (!attachService.createAll(merchantDto.getAttachList(), merchant.getRecId())) {
                throw new DatabaseException("error.merchant.insert");
            }
        } else {
            throw new DatabaseException("error.merchant.insert");
        }
        MerchantDto curMerchant = new MerchantDto();
        curMerchant.setMerchant(merchantMapper.selectByPrimaryKey(merchant.getRecId()));
        curMerchant.setAttachList(attachService.findByMasterId(merchant.getRecId()));
        return curMerchant;
    }
    
    public Merchant queryMerchantById(String recId) {
    	return merchantMapper.selectByPrimaryKey(recId);
    }

    public MerchantDto findByPrimaryKey(String key){
        MerchantDto curMerchant = new MerchantDto();
        curMerchant.setMerchant(merchantMapper.selectByPrimaryKey(key));
        curMerchant.setAttachList(attachService.findByMasterId(key));
        return curMerchant;
    }

}
