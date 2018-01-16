package com.mmnttech.ma.merchant.server.service;

import com.mmnttech.ma.merchant.server.common.exception.DatabaseException;
import com.mmnttech.ma.merchant.server.mapper.MerchantCertMapper;
import com.mmnttech.ma.merchant.server.model.MerchantCert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Stelo
 * @createAt 2018/1/16
 **/
@Transactional(rollbackFor = DatabaseException.class)
@Service("merchantCertService")
public class MerchantCertService {

    @Autowired
    private MerchantCertMapper merchantCertMapper;

    public List<MerchantCert> queryMerchantCertByAreaCodeAndIndustryCode(String areaCode, String industryCode) {
        MerchantCert merchantCert = new MerchantCert();
        merchantCert.setAreaCode(areaCode);
        merchantCert.setIndustryCode(industryCode);
        return merchantCertMapper.select(merchantCert);
    }
}
