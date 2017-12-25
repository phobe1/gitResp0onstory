package com.bdqn.agentSystem.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.agentSystem.domain.RoleMapper;
import com.bdqn.agentSystem.pojo.Role;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleMapper  roleMapper;
	@Override
	public List<Role> getRoleList()  throws Exception{
		// TODO Auto-generated method stub
		return roleMapper.getRoleList();
	}

	@Override
	public Role getRole(Role role)  throws Exception{
		// TODO Auto-generated method stub
		return roleMapper.getRole(role);
	}

	@Override
	public int addRole(Role role)  throws Exception{
		// TODO Auto-generated method stub
		return roleMapper.addRole(role);
	}

	@Override
	public int modifyRole(Role role)  throws Exception{
		// TODO Auto-generated method stub
		return roleMapper.modifyRole(role);
	}

	@Override
	public int deleteRole(Role role)  throws Exception{
		// TODO Auto-generated method stub
		return roleMapper.deleteRole(role);
	}

	@Override
	public List<Role> getRoleIdAndNameList() throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.getRoleIdAndNameList();
	}

}
