package com.mmnttech.ma.merchant.server.database.mappers;

import com.mmnttech.ma.merchant.server.database.entity.MerchantUser;
import com.mmnttech.ma.merchant.server.database.entity.MerchantUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantUserMapper {
    long countByExample(MerchantUserExample example);

    int deleteByExample(MerchantUserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(MerchantUser record);

    int insertSelective(MerchantUser record);

    List<MerchantUser> selectByExample(MerchantUserExample example);

    MerchantUser selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") MerchantUser record, @Param("example") MerchantUserExample example);

    int updateByExample(@Param("record") MerchantUser record, @Param("example") MerchantUserExample example);

    int updateByPrimaryKeySelective(MerchantUser record);

    int updateByPrimaryKey(MerchantUser record);
}