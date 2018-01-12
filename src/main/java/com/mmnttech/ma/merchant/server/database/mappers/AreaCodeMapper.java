package com.mmnttech.ma.merchant.server.database.mappers;

import com.mmnttech.ma.merchant.server.database.entity.AreaCode;
import com.mmnttech.ma.merchant.server.database.entity.AreaCodeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaCodeMapper {
    long countByExample(AreaCodeExample example);

    int deleteByExample(AreaCodeExample example);

    int deleteByPrimaryKey(String recId);

    int insert(AreaCode record);

    int insertSelective(AreaCode record);

    List<AreaCode> selectByExample(AreaCodeExample example);

    AreaCode selectByPrimaryKey(String recId);

    int updateByExampleSelective(@Param("record") AreaCode record, @Param("example") AreaCodeExample example);

    int updateByExample(@Param("record") AreaCode record, @Param("example") AreaCodeExample example);

    int updateByPrimaryKeySelective(AreaCode record);

    int updateByPrimaryKey(AreaCode record);
}