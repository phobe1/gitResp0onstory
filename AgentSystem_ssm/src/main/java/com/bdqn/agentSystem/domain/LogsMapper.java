package com.bdqn.agentSystem.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bdqn.agentSystem.pojo.Logs;

@Mapper
public interface LogsMapper {
	/**
	 * getList
	 * @return
	 */
	public List<Logs> getList(Logs logs) throws Exception;
	/**
	 * addLogs
	 * @param logs
	 * @return
	 */
	public int addLogs(Logs logs) throws Exception;
	
	/**
	 * @param logs
	 * @return
	 * @throws Exception
	 */
	public int count(Logs logs) throws Exception;
	
}
