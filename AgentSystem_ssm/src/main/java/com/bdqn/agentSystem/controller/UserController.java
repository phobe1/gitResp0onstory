package com.bdqn.agentSystem.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdqn.agentSystem.pojo.Account;
import com.bdqn.agentSystem.pojo.Function;
import com.bdqn.agentSystem.pojo.Premission;
import com.bdqn.agentSystem.pojo.Role;
import com.bdqn.agentSystem.pojo.RoleFunctions;
import com.bdqn.agentSystem.pojo.User;
import com.bdqn.agentSystem.service.AccountService;
import com.bdqn.agentSystem.service.FunctionService;
import com.bdqn.agentSystem.service.PremissionServiceImpl;
import com.bdqn.agentSystem.service.RoleService;
import com.bdqn.agentSystem.service.UserService;
import com.bdqn.agentSystem.util.Constants;
import com.bdqn.agentSystem.util.MD5;

@Controller
public class UserController {
	Logger log = Logger.getLogger(UserController.class);
	@Resource
	UserService userService;

	@Resource
	AccountService accountService;

	@Resource
	PremissionServiceImpl premissionService;

	@Resource
	FunctionService functionService;

	@Resource
	RoleService roleService;

	@RequestMapping("/")
	public String index(User user) {
		return "login";
	}

	public HashMap<Integer, ArrayList<RoleFunctions>> MENU = Constants.MENU;

	@RequestMapping("login.action")
	public String login(User user, HttpSession session) {
		User loginuser = null;
		try {
			user.setUserPassword(MD5.MD5Encode(user.getUserPassword()));
			log.debug("------>user:" + user.getUserName() + "," + user.getUserPassword());
			loginuser = userService.login(user);
			if (loginuser == null) {
				return "login";
			} else {

				User updateLoginTimeUser = new User();
				updateLoginTimeUser.setId(loginuser.getId());
				updateLoginTimeUser.setLastLoginTime(new Date());
				loginuser.setLastLoginTime(new Date());
				session.setAttribute("currentUser", loginuser);
				userService.modifyUser(updateLoginTimeUser);
				updateLoginTimeUser = null;
				System.out.println("-----------------------------------");
				log.debug("User login : " + loginuser.getUserCode() + " - " + loginuser.getUserName());

				// this.setFuncList(getFuncByCurrentUser(_user.getRoleId()));
				// logger.error("====================>"+ funcList.size());
				return "redirect:/main.action";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping("validateLoginUser.action")
	@ResponseBody
	public String validateLoginUser(User user) {
		String flag = "failed";
		if (null != user && !"".equals(user.getUserCode())) {
			try {
				user.setUserPassword(MD5.MD5Encode(user.getUserPassword()));
				System.out.println(user.getUserCode() + "," + user.getUserPassword());
				if (userService.isExitLoginUser(user) == 0) {
					flag = "noexitusercode";
				} else if (userService.login(user) == null) {
					flag = "errorpwd";
				} else {
					flag = "success";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	@RequestMapping("/exit.action")
	public String exit(HttpSession session, User user) {
		try {
			System.out.println("----------exit");
			user = (User) session.getAttribute("currentUser");
			if (user != null && user.getId() > 0) {
				// setLog(user,Constants.OPERATE_INFO_USER_LOGOUT_SUCCESS);
				session.invalidate();
				session.removeAttribute("currentUser");
				log.error("User logout : " + user.getUserCode() + " - " + user.getUserName());
				user = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}

	@RequestMapping("/main.action")
	public String main(HttpSession session, Model model) {
		// 查询当前账户的信息，User信息从session中取
		// 查询当前的账户的余额信息
		Account account = new Account();
		User cu = (User) session.getAttribute("currentUser");
		// if() {
		//
		// }
		account.setUserId(cu.getId());
		List<Function> funcList = new ArrayList<Function>();

		List<RoleFunctions> roleFunctions = new ArrayList<RoleFunctions>();
		try {
			// funcList = getFuncByCurrentUser(cu.getRoleId());
			account = accountService.getAccount(account);
			if (MENU.size() > 0) {
				roleFunctions = MENU.get(cu.getRoleId());
			}

			System.out.println(roleFunctions.size());
			System.out.println(roleFunctions);
			System.out.println(account.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			account = null;
			return "error";
		}
		model.addAttribute("roleFunctions", roleFunctions);
		// model.addAttribute("funcList", funcList);
		System.out.println("-------------");
		model.addAttribute("account", account);
		return "main";
	}

	private List<Function> getFuncByCurrentUser(int roleId) {
		List<Function> fList = new ArrayList<Function>();
		// if(premission == null)
		Premission premission = new Premission();
		premission.setRoleId(roleId);
		premission.setIsStart(1);
		try {
			List<Premission> premissionList = premissionService.getList(premission);
			if (premissionList != null) {

				for (int j = 0; j < premissionList.size(); j++) {
					// if(function == null)
					Function function = new Function();
					function.setId(premissionList.get(j).getFunctionId());
					function = functionService.getFunctionById(function);
					log.error("function getFuncUrl ========================================================== "
							+ function.getFuncUrl());
					fList.add(function);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.error("fList ========================================================== " + fList.size());
		return fList;
	}

	public void fl() throws Exception {
		List<Role> roleList = roleService.getRoleIdAndNameList();
		List<Function> menuFunctionList = functionService.getMenuFunction();
		List<Function> fList;
		ArrayList<RoleFunctions> roleFunctionsList;

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

	}

}
