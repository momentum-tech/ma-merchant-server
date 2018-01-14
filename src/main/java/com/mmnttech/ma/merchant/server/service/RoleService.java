package com.mmnttech.ma.merchant.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Example;

import com.mmnttech.ma.merchant.server.common.entity.QueryEntity;
import com.mmnttech.ma.merchant.server.common.entity.RtnMessage;
import com.mmnttech.ma.merchant.server.mapper.MenuGroupMapper;
import com.mmnttech.ma.merchant.server.mapper.RoleMapper;
import com.mmnttech.ma.merchant.server.mapper.RoleMenuGroupMapper;
import com.mmnttech.ma.merchant.server.model.MenuGroup;
import com.mmnttech.ma.merchant.server.model.Role;
import com.mmnttech.ma.merchant.server.model.RoleMenuGroup;
import com.mmnttech.ma.merchant.server.util.StringUtil;
import com.mmnttech.ma.merchant.server.util.Validator;

/**
 * @类名 RoleService
 * @描述:
 *   TODO
 * @版权: Copyright (c) 2017 easepay
 * @创建人 James
 * @创建时间 2017年12月28日 上午9:54:16
 * @版本 v1.0
 * 
 */
@Service("roleService")
public class RoleService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RoleMenuGroupMapper roleMenuGroupMapper;
	
	@Autowired
	private MenuGroupMapper menuGroupMapper;
	
	public List<Map<String, Object>> queryRoleLst(QueryEntity queryEntity) {
		List<Object> paramLst = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM t_role WHERE 1 = 1");
		
		if(Validator.isNotBlank(queryEntity.getQueryName())) {
			sql.append(" AND name = ?");
			paramLst.add(queryEntity.getQueryName());
		}

		int offset = (queryEntity.getPage() - 1) * queryEntity.getRows();
		
		sql.append(" ORDER BY create_date desc LIMIT ?, ?");
		paramLst.add(offset);
		paramLst.add(queryEntity.getRows());
		
		return jdbcTemplate.queryForList(sql.toString(), paramLst.toArray());
	}
	
	public Role queryRoleById(String roleId) {
		return roleMapper.selectByPrimaryKey(roleId);
	}
	
	public Role queryMerchanteRoleInfo() {
		Example example = new Example(Role.class);
		example.createCriteria()
				.andEqualTo("name", "商户")
				.andEqualTo("platform", "商户认证平台");
		List<Role> roleLst = roleMapper.selectByExample(example);
		if(roleLst != null && !roleLst.isEmpty()) {
			return roleLst.get(0);
		}
		return null;
	}
	
	public RtnMessage createRole(Role role) {
		RtnMessage rtnMsg = new RtnMessage();
		List<Object> paramLst = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(1) cnt FROM t_role WHERE name = ? AND platform = ? ");
		
		paramLst.add(role.getName());
		paramLst.add(role.getPlatform());
		
		if(jdbcTemplate.queryForObject(sql.toString(), Integer.class, paramLst.toArray()) == 0) {
			role.setRecId(StringUtil.getUUID());
			role.setCreateDate(new Date());
			
			roleMapper.insert(role);
		} else {
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage("创建角色失败: 相同的角色名称重复");
		}
		return rtnMsg;
	}
	
	public RtnMessage updateRole(Role role) {
		RtnMessage rtnMsg = new RtnMessage();
		List<Object> paramLst = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(1) cnt FROM t_menu WHERE name = ? AND flatform = ? AND rec_id != ?");
		
		paramLst.add(role.getName());
		paramLst.add(role.getPlatform());
		paramLst.add(role.getRecId());
		
		if(jdbcTemplate.queryForObject(sql.toString(), Integer.class, paramLst.toArray()) == 0) {
			roleMapper.updateByPrimaryKeySelective(role);
		} else {
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage("修改角色失败: 相同的角色名称重复");
		}
		return rtnMsg;
	}
	
	public RtnMessage deleteRole(Role role) {
		RtnMessage rtnMsg = new RtnMessage();
		List<Object> paramLst = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(1) cnt FROM t_role_menu_group WHERE role_id = ? ");
		
		paramLst.add(role.getRecId());
		
		if(jdbcTemplate.queryForObject(sql.toString(), Integer.class, paramLst.toArray()) == 0) {
			roleMapper.deleteByPrimaryKey(role.getRecId());
		} else {
			rtnMsg.setIsSuccess(false);
			rtnMsg.setMessage("删除角色失败：该角色关联了菜单组");
		}
		
		return rtnMsg;
	}
	
	
	@Transactional
	public void txCreatePaymentStatement(List<RoleMenuGroup> roleMenuGroupLst, String roleId) {
		List<String> menuGroupIdLst = new ArrayList<String>();

		RoleMenuGroup roleMenuGroup = new RoleMenuGroup();
		roleMenuGroup.setRoleId(roleId);
		roleMenuGroupMapper.delete(roleMenuGroup);

		if(roleMenuGroupLst != null && !roleMenuGroupLst.isEmpty()) {
			for(RoleMenuGroup curRoleMenuGroup : roleMenuGroupLst) {
				menuGroupIdLst.add(curRoleMenuGroup.getMenuGroupId());

				curRoleMenuGroup.setRecId(StringUtil.getUUID());
				curRoleMenuGroup.setCreateDate(new Date());
				
				roleMenuGroupMapper.insert(curRoleMenuGroup);
			}


			Example example = new Example(MenuGroup.class);
			example.createCriteria().andIn("rec_id",menuGroupIdLst);
			example.setOrderByClause("sequence");
			
			List<MenuGroup> menuGroupLst = menuGroupMapper.selectByExample(example);
			for(int i = 0; i < menuGroupLst.size(); i ++) {
				MenuGroup record = menuGroupLst.get(i);
				record.setSequence(i + 1);
				
				menuGroupMapper.updateByPrimaryKeySelective(record);
			}
		}
	}

	public List<String> queryRoleMenuInfos(Role role) {
		List<String> menuGroupIdLst = new ArrayList<String>();
		List<Object> paramLst = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT menu_group_id FROM t_role_menu_group WHERE role_id = ?");
		paramLst.add(role.getRecId());

		List<Map<String, Object>> records = jdbcTemplate.queryForList(sql.toString(), paramLst.toArray());
		for(Map<String, Object> record : records) {
			menuGroupIdLst.add(String.valueOf(record.get("menu_group_id")));
		}
		
		return menuGroupIdLst;
	}
	
	
}
