package com.mmnttech.ma.merchant.server.database.mappers;

import com.mmnttech.ma.merchant.server.database.entity.RoleMenuGroup;
import com.mmnttech.ma.merchant.server.database.entity.RoleMenuGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuGroupMapper {
    long countByExample(RoleMenuGroupExample example);

    int deleteByExample(RoleMenuGroupExample example);

    int deleteByPrimaryKey(String recId);

    int insert(RoleMenuGroup record);

    int insertSelective(RoleMenuGroup record);

    List<RoleMenuGroup> selectByExample(RoleMenuGroupExample example);

    RoleMenuGroup selectByPrimaryKey(String recId);

    int updateByExampleSelective(@Param("record") RoleMenuGroup record, @Param("example") RoleMenuGroupExample example);

    int updateByExample(@Param("record") RoleMenuGroup record, @Param("example") RoleMenuGroupExample example);

    int updateByPrimaryKeySelective(RoleMenuGroup record);

    int updateByPrimaryKey(RoleMenuGroup record);
}