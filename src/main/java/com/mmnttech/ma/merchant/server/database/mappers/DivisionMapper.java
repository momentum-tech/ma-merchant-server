package com.mmnttech.ma.merchant.server.database.mappers;

import com.mmnttech.ma.merchant.server.database.entity.Division;
import com.mmnttech.ma.merchant.server.database.entity.DivisionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DivisionMapper {
    int countByExample(DivisionExample example);

    int deleteByExample(DivisionExample example);

    int deleteByPrimaryKey(String divCode);

    int insert(Division record);

    int insertSelective(Division record);

    List<Division> selectByExample(DivisionExample example);

    Division selectByPrimaryKey(String divCode);

    int updateByExampleSelective(@Param("record") Division record, @Param("example") DivisionExample example);

    int updateByExample(@Param("record") Division record, @Param("example") DivisionExample example);

    int updateByPrimaryKeySelective(Division record);

    int updateByPrimaryKey(Division record);
}