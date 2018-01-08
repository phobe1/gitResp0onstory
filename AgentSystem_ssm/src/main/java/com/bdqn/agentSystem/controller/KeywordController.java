package com.bdqn.agentSystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.bdqn.agentSystem.pojo.Account;
import com.bdqn.agentSystem.pojo.Custom;
import com.bdqn.agentSystem.pojo.SystemConfig;
import com.bdqn.agentSystem.pojo.User;
import com.bdqn.agentSystem.service.AccountService;
import com.bdqn.agentSystem.util.Constants;
import com.bdqn.agentSystem.util.SQLTools;


@Controller
public class KeywordController extends BaseController {
	@Resource
	AccountService accountService;
	
	@RequestMapping("/keyword.action")
	public String init(Model model ) {
	List<SystemConfig>	serviceType = Constants.serviceConfigList;
	SystemConfig 	systemConfig = Constants.maxServiceYearsConfig;
	List<SystemConfig>	youhuiType = Constants.youhuiTypeConfigList;
		Account account = new Account();
		account.setUserId(Constants.user.getId());
		try {
			account = accountService.getAccount(account);
			model.addAttribute("account", account);
			model.addAttribute("youhuiType", youhuiType);
			model.addAttribute("serviceType", serviceType);
			model.addAttribute("systemConfig", systemConfig);
			
			System.out.println("---------->account:"+account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "keyword";
	}
	
	//,produces="application/json;charset=UTF-8"
	@RequestMapping(value="/searchcustom.action")
	@ResponseBody
	public Object searchCustom1(Custom custom,HttpSession session) {
		System.out.println(custom);
		if(custom.getCustomName()!=null&&!custom.getCustomName().equals("")) {
			custom.setCustomName("%"+SQLTools.transfer(custom.getCustomName())+"%");	
		}
		System.out.println(custom.getCustomName());
		User user = (User) session.getAttribute(Constants.SESSION_USER);
		
		custom.setAgentId(user.getId());
		List<Custom> list = new ArrayList<Custom>();
		
		list = this.searchCustom(list,custom);
		System.out.println("------------>customList:"+list.size());
		String re = JSONArray.toJSONString(list);
		return re;
	}
	
	
//	public void searchCustom(){
//		try {
//			//user.userCode=han
//			custom.setCustomName("%"+SQLTools.transfer(custom.getCustomName())+"%");
//			customList = this.searchCustom(customList, custom);
//			if(null == customList){
//				customList = new ArrayList<Custom>();
//			}
//			logger.error("--->" + customList.size());
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			customList = new ArrayList<Custom>();
//		}
//		this.getOut().write((JSONArray.fromObject(customList)).toString());
//		this.closeOut(this.getOut());
//	}

}
