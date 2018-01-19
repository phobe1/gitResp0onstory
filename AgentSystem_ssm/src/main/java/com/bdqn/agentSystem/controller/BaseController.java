package com.bdqn.agentSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bdqn.agentSystem.pojo.Custom;
import com.bdqn.agentSystem.service.CustomService;

@Controller
public class BaseController {
	
	@Autowired
	private CustomService customService;
	
	//客户搜索功能，返回 Custom List
	public List<Custom> searchCustom(List<Custom> customList,Custom custom){
			
			try {
				custom.setCustomStatus(1);
				customList = customService.getCustomBySearch(custom);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return customList;
		}

}
