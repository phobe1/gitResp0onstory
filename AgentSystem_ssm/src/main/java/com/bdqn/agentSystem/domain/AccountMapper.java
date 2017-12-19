package com.bdqn.agentSystem.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bdqn.agentSystem.pojo.Account;


@Mapper
public interface AccountMapper {
	
	/**
	 * getAccountList
	 * @param account
	 * @return
	 */
	public List<Account> getAccountList(Account account) throws Exception;
	
	/**
	 * getAccount
	 * @param account
	 * @return
	 */
	public Account getAccount(Account account) throws Exception;
	
	/**
	 * addAccount
	 * @param account
	 * @return
	 */
	public int addAccount(Account account) throws Exception;
	
	/**
	 * modifyAccount
	 * @param account
	 * @return
	 */
	public int modifyAccount(Account account) throws Exception;
	
	/**
	 * deleteAccount
	 * @param account
	 * @return
	 */
	public int deleteAccount(Account account) throws Exception;
}
