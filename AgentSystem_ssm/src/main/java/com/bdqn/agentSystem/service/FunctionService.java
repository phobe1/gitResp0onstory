package com.bdqn.agentSystem.service;

import java.util.List;

import com.bdqn.agentSystem.pojo.Function;


public interface FunctionService { 
	/**
     * getFunctionList
     * @param function
     * @return
     */
	public List<Function> getFunctionList() throws Exception;
	/**
	 * getMenuFunction
	 * @return
	 * @throws Exception
	 */
	public List<Function> getMenuFunction() throws Exception;
	
	/**
	 * getFunctionById
	 * @return
	 * @throws Exception
	 */
	public Function getFunctionById(Function function) throws Exception;
		
}
