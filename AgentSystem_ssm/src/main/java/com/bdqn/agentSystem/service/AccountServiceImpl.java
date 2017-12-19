package com.bdqn.agentSystem.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.agentSystem.domain.AccountMapper;
import com.bdqn.agentSystem.pojo.Account;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Resource
	private AccountMapper accountMapper;
//	@Autowired
//	private AccountDetailMapper accountDetailmapper;
//	@Autowired
//	private LogsMapper logsmapper;
	@Override
	public List<Account> getAccountList(Account account)  throws Exception{
		// TODO Auto-generated method stub
		return accountMapper.getAccountList(account);
	}

	@Override
	public Account getAccount(Account account)  throws Exception{
		// TODO Auto-generated method stub
		return accountMapper.getAccount(account);
	}

	@Override
	public int addAccount(Account account)  throws Exception{
		// TODO Auto-generated method stub
		return accountMapper.addAccount(account);
	}

	@Override
	public int modifyAccount(Account account)  throws Exception{
		// TODO Auto-generated method stub
		return accountMapper.modifyAccount(account);
	}

	@Override
	public int deleteAccount(Account account)  throws Exception{
		// TODO Auto-generated method stub
		return accountMapper.deleteAccount(account);
	}

//	@Override
//	public boolean hl_operationAccount(Account oldAccount, Account newAccount,AccountDetail accountDetail,Logs logs)
//			throws Exception {
//		// 资金计算
//		oldAccount.setMoney(AccountsUtil.add(oldAccount.getMoney(),newAccount.getMoney()));
//		oldAccount.setMoneyBak(AccountsUtil.add(oldAccount.getMoneyBak(),newAccount.getMoney()));
//		//修改账户资金
//		mapper.modifyAccount(oldAccount);
//		//记录流水
//		accountDetailmapper.addAccountDetail(accountDetail);
//		//记录管理员操作信息
//		logsmapper.addLogs(logs);
//		return false;
//	}

}
