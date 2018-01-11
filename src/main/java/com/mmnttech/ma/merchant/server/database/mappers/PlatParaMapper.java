package com.mmnttech.ma.merchant.server.database.mappers;

import com.mmnttech.ma.merchant.server.database.entity.PlatPara;
import com.mmnttech.ma.merchant.server.database.entity.PlatParaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlatParaMapper {
    long countByExample(PlatParaExample example);

    int deleteByExample(PlatParaExample example);

    int deleteByPrimaryKey(String platNo);

    int insert(PlatPara record);

    int insertSelective(PlatPara record);

    List<PlatPara> selectByExample(PlatParaExample example);

    PlatPara selectByPrimaryKey(String platNo);

    int updateByExampleSelective(@Param("record") PlatPara record, @Param("example") PlatParaExample example);

    int updateByExample(@Param("record") PlatPara record, @Param("example") PlatParaExample example);

    int updateByPrimaryKeySelective(PlatPara record);

    int updateByPrimaryKey(PlatPara record);
}