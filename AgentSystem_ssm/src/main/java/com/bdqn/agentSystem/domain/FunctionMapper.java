package com.bdqn.agentSystem.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bdqn.agentSystem.pojo.Function;

@Mapper
public interface FunctionMapper {
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
