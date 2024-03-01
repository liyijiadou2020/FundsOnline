package com.atguigu.crowd.service.api;

import java.util.List;

import com.atguigu.crowd.entity.Role;
import com.github.pagehelper.PageInfo;

public interface RoleService {
	
	PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword);

	void saveRole(Role role);

	void updateRole(Role role);
	
	void removeRole(List<Integer> roleIdList);

	/**
	 * 获取分配的角色
	 * @param adminId
	 * @return 已获取的角色列表
	 */
	List<Role> getAssignedRole(Integer adminId);

	/**
	 * 获取未分配的角色
	 * @param adminId
	 * @return 未获取的角色列表
	 */
	List<Role> getUnAssignedRole(Integer adminId);

}
