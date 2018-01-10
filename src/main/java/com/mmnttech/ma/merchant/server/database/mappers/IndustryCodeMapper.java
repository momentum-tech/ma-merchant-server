package com.mmnttech.ma.merchant.server.database.mappers;

import com.mmnttech.ma.merchant.server.database.entity.IndustryCode;
import com.mmnttech.ma.merchant.server.database.entity.IndustryCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndustryCodeMapper {
    long countByExample(IndustryCodeExample example);

    int deleteByExample(IndustryCodeExample example);

    int deleteByPrimaryKey(String recId);

    int insert(IndustryCode record);

    int insertSelective(IndustryCode record);

    List<IndustryCode> selectByExample(IndustryCodeExample example);

    IndustryCode selectByPrimaryKey(String recId);

    int updateByExampleSelective(@Param("record") IndustryCode record, @Param("example") IndustryCodeExample example);

    int updateByExample(@Param("record") IndustryCode record, @Param("example") IndustryCodeExample example);

    int updateByPrimaryKeySelective(IndustryCode record);

    int updateByPrimaryKey(IndustryCode record);
}