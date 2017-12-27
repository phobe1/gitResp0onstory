package com.bdqn.agentSystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdqn.agentSystem.pojo.Account;
import com.bdqn.agentSystem.pojo.SystemConfig;
import com.bdqn.agentSystem.util.Constants;

@Controller
public class KeywordController {
	
	@RequestMapping("/keyword.action")
	public String init() {
	List<SystemConfig>	serviceType = Constants.serviceConfigList;
	SystemConfig 	systemConfig = Constants.maxServiceYearsConfig;
	List<SystemConfig>	youhuiType = Constants.youhuiTypeConfigList;
		Account account = new Account();
		account.setUserId(Constants.user.getId());
//		try {
//			account = accountService.getAccount(account);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		return "keyword";
	}

}
