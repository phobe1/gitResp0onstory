package com.bdqn.agentSystem.service;

import java.util.List;

import com.bdqn.agentSystem.pojo.Premission;


public interface PremissionService {
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
	/**
	 * hl_delAddPremission
	 * @param premission
	 * @return
	 * @throws Exception
	 */
	public boolean hl_delAddPremission(Premission premission,String checkFuncList) throws Exception;
}
