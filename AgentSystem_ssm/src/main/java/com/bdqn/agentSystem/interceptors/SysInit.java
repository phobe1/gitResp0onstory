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
import com.bdqn.agentSystem.service.FunctionService;
import com.bdqn.agentSystem.service.PremissionServiceImpl;
import com.bdqn.agentSystem.service.RoleService;

@Component("sysInit")
public class SysInit extends HandlerInterceptorAdapter {
	@Resource
	PremissionServiceImpl premissionService;

	@Resource
	FunctionService functionService;

	@Resource
	RoleService roleService;

	public static HashMap<Integer, ArrayList<RoleFunctions>> MENU = new HashMap<Integer, ArrayList<RoleFunctions>>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		List<Role> roleList = roleService.getRoleIdAndNameList();
		List<Function> menuFunctionList = functionService.getMenuFunction();
		List<Function> fList;
		ArrayList<RoleFunctions> roleFunctionsList;
		HttpSession session = request.getSession();
		MENU = (HashMap<Integer, ArrayList<RoleFunctions>>) session.getAttribute("menu");
		if (MENU != null && MENU.size() > 0) {
			return true;
		} else {

			for (Role role : roleList) {
				fList = new ArrayList<Function>();
				roleFunctionsList = new ArrayList<RoleFunctions>();
				Premission premission = new Premission();
				premission.setRoleId(role.getId());
				premission.setIsStart(1);
				List<Premission> premissionList = premissionService.getList(premission);
				for (int j = 0; j < premissionList.size(); j++) {
					Function function = new Function();
					function.setId(premissionList.get(j).getFunctionId());
					function = functionService.getFunctionById(function);
					fList.add(function);
				}

				List<Function> subFunction;
				for (Function f : menuFunctionList) {
					RoleFunctions roleFunctions = new RoleFunctions();
					roleFunctions.setMainFunction(f);
					subFunction = new ArrayList<Function>();
					if (null != fList && fList.size() > 0) {
						for (Function subf : fList) {
							if (subf.getParentId() == f.getId()) {
								subFunction.add(subf);
							}
						}
					}
					roleFunctions.setSubFunctions(subFunction);
					roleFunctionsList.add(roleFunctions);
				}
				MENU.put(role.getId(), roleFunctionsList);

			}
			session.setAttribute("menu", MENU);

		}
		return true;
	}

}
