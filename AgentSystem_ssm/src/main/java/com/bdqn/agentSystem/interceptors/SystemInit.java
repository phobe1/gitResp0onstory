package com.bdqn.agentSystem.interceptors;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bdqn.agentSystem.pojo.*;
import com.bdqn.agentSystem.service.*;
import com.bdqn.agentSystem.util.Constants;

@Component("SystemInit")
public class SystemInit implements ApplicationListener<ContextRefreshedEvent>{
	
	private Logger logger = Logger.getLogger(SystemInit.class);
	
	@Resource
	PremissionServiceImpl premissionService;

	@Resource
	FunctionService functionService;

	@Resource
	RoleService roleService;
	
	@Resource
	SystemConfigService systemConfigService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
				System.out.println("Init Spring WebApplicationContext Start.");
				Constants.cxt=event.getApplicationContext();
				if( null == Constants.cxt )
					System.out.println("WebApplicationContext Init failed.");
				System.out.println("Init Spring WebApplicationContext end.");
				
				if(null != Constants.cxt){
					System.out.println("init datas starting...");
					SystemConfigService systemConfigService = (SystemConfigService)Constants.cxt.getBean("systemConfigService");
					RoleService roleService = (RoleService)Constants.cxt.getBean("roleService");
					PremissionService premissionService = (PremissionService)Constants.cxt.getBean("premissionService");
					FunctionService functionService = (FunctionService)Constants.cxt.getBean("functionService");
					try {
						SystemConfig sc = new SystemConfig();
						sc.setIsStart(1);
						System.out.println(systemConfigService);
						System.out.println("Constants.systemConfigList----------");
						Constants.systemConfigList = systemConfigService.getSystomConfigs(sc);
						System.out.println("systemConfigService end");
						Constants.configSystemData();
						logger.error("------------>"+Constants.accountConfigList.size());
						logger.error("------------>"+Constants.serviceConfigList.size());
						logger.error("------------>"+Constants.maxServiceYearsConfig.getConfigValue());
						logger.error("------------>"+Constants.appMakeUrlConfig.getConfigValue());
						logger.error("------------>"+Constants.customTypeConfigList.size());
						logger.error("------------>"+Constants.cardTypeConfigList.size());
						
						//init menu
						List<Role> roleList = roleService.getRoleIdAndNameList();
						List<Function> menuFunctionList = functionService.getMenuFunction();
						List<Function> fList;
						ArrayList<RoleFunctions> roleFunctionsList;

						for(Role role : roleList){
							fList = new ArrayList<Function>();
							roleFunctionsList = new ArrayList<RoleFunctions>();
							Premission premission = new Premission();
							premission.setRoleId(role.getId());
							premission.setIsStart(1);
							List<Premission> premissionList = premissionService.getList(premission);
							for(int j = 0; j < premissionList.size(); j++){
								Function function = new Function();
								function.setId(premissionList.get(j).getFunctionId());
								function = functionService.getFunctionById(function);
								fList.add(function);
							}
							
							List<Function> subFunction;
							for(Function f:menuFunctionList){
								RoleFunctions roleFunctions = new RoleFunctions();
								roleFunctions.setMainFunction(f);
								subFunction = new ArrayList<Function>();
								if( null != fList && fList.size() > 0){
									for(Function subf : fList){
										if(subf.getParentId() == f.getId()){
											subFunction.add(subf);
										}
									}
								}
								roleFunctions.setSubFunctions(subFunction);
								roleFunctionsList.add(roleFunctions);
							}
							Constants.MENU.put(role.getId(), roleFunctionsList);

						}
							
						logger.error("Role list:" + Constants.MENU.size());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logger.error("init datas failed.");
					}
					logger.error("init datas end.");
				}
		
	}

}
