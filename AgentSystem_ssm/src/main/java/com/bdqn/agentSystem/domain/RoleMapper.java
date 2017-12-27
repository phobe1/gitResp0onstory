package com.bdqn.agentSystem.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bdqn.agentSystem.pojo.Role;


@Mapper
public interface RoleMapper {
	
		/**
		 * getRoleList
		 * @return
		 */
		public List<Role> getRoleList() throws Exception;
			
		/**
		 * getRole
		 * @param role
		 * @return
		 */
		public Role getRole(Role role) throws Exception;
		
		/**
		 * addRole
		 * @param role
		 * @return
		 */
		public int addRole(Role role) throws Exception;
		
		/**
		 * modifyRole
		 * @param role
		 * @return
		 */
		public int modifyRole(Role role) throws Exception;
		
		/**
		 * deleteRole
		 * @param role
		 * @return
		 */
		public int deleteRole(Role role) throws Exception;
		
		/**
		 * getRoleIdAndNameList
		 * @return
		 */
		public List<Role> getRoleIdAndNameList() throws Exception;
}
