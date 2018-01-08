package com.bdqn.agentSystem.interceptors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bdqn.agentSystem.pojo.Function;
import com.bdqn.agentSystem.pojo.Premission;
import com.bdqn.agentSystem.pojo.Role;
import com.bdqn.agentSystem.pojo.RoleFunctions;
import com.bdqn.agentSystem.pojo.SystemConfig;
import com.bdqn.agentSystem.pojo.User;
import com.bdqn.agentSystem.service.FunctionService;
import com.bdqn.agentSystem.service.PremissionServiceImpl;
import com.bdqn.agentSystem.service.RoleService;
import com.bdqn.agentSystem.service.SystemConfigService;
import com.bdqn.agentSystem.util.Constants;


@Component("SysInit")
public class SysInit extends HandlerInterceptorAdapter {

	public static HashMap<Integer, ArrayList<RoleFunctions>> MENU = Constants.MENU;

	
	public static List<SystemConfig> systemConfigList;
	//账务类型列表 1
	public static List<SystemConfig> accountConfigList = new ArrayList<SystemConfig>();
	//服务类型  2 上传苹果商店
	public static List<SystemConfig> serviceConfigList = new ArrayList<SystemConfig>();
	//服务年限 3 最大的服务年限
	public static SystemConfig maxServiceYearsConfig;
	//app 制作URL  4
	public static SystemConfig appMakeUrlConfig;
	//客户类型 5
	public static List<SystemConfig> customTypeConfigList = new ArrayList<SystemConfig>();
	//证件类型 6
	public static List<SystemConfig> cardTypeConfigList = new ArrayList<SystemConfig>();
	//优惠类型 7
	public static List<SystemConfig> youhuiTypeConfigList = new ArrayList<SystemConfig>();
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
//		SystemConfig sc = new SystemConfig();
//		sc.setIsStart(1);
//		systemConfigList = systemConfigService.getSystomConfigs(sc);
//		configSystemData();
		
		List<RoleFunctions> roleFunctions = new ArrayList<RoleFunctions>();
		Constants.user=(User)(request.getSession().getAttribute(Constants.SESSION_USER));
		if (MENU != null && MENU.size() > 0) {
			System.out.println("------------>Constants.user:"+Constants.user);
			if(Constants.user==null) {
				response.sendRedirect("/");
				return false;
			}else {
				roleFunctions = Constants.MENU.get(Constants.user.getRoleId());
				session.setAttribute("roleFunctions", roleFunctions);
				return true;
			}
			
		} else {
			session.setAttribute("menu", MENU);
			return true;
		}
		
	}
	
	
public static void configSystemData(){
		
		accountConfigList.clear();
		accountConfigList = null;
		accountConfigList = new ArrayList<SystemConfig>();
		
		serviceConfigList.clear();
		serviceConfigList = null;
		serviceConfigList = new ArrayList<SystemConfig>();
		
		maxServiceYearsConfig = null;
		maxServiceYearsConfig = new SystemConfig();
		
		appMakeUrlConfig = null;
		appMakeUrlConfig = new SystemConfig();
		
		customTypeConfigList.clear();
		customTypeConfigList = null;
		customTypeConfigList = new ArrayList<SystemConfig>();
		
		cardTypeConfigList.clear();
		cardTypeConfigList = null;
		cardTypeConfigList = new ArrayList<SystemConfig>();
		
		youhuiTypeConfigList.clear();
		youhuiTypeConfigList = null;
		youhuiTypeConfigList = new ArrayList<SystemConfig>();
		
		for(SystemConfig sc : systemConfigList){
			switch(sc.getConfigType()){
			case 1:
				accountConfigList.add(sc);
				break;
			case 2:
				serviceConfigList.add(sc);
				break;
			case 3:
				maxServiceYearsConfig = sc;
				break;
			case 4:
				appMakeUrlConfig = sc;
				break;
			case 5:
				customTypeConfigList.add(sc);
				break;
			case 6:
				cardTypeConfigList.add(sc);
				break;
			case 7:
				youhuiTypeConfigList.add(sc);
				break;
			
			}
		}
	}

}
