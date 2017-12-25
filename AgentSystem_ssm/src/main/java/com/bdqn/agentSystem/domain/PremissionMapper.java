package com.bdqn.agentSystem.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bdqn.agentSystem.pojo.Premission;

@Mapper
public interface PremissionMapper {
	/**
	 * getList
	 * @return
	 */
	public List<Premission> getList(Premission premission) throws Exception;
	/**
	 * addPremission
	 * @param premission
	 * @return
	 */
	public int addPremission(Premission premission) throws Exception;
	/**
	 * modifyPremission
	 * @param premission
	 * @return
	 */
	public int modifyPremission(Premission premission) throws Exception;
	/**
	 * deletePremission
	 * @param premission
	 * @return
	 */
	public int deletePremission(Premission premission) throws Exception;
	
}
