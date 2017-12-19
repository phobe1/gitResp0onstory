package com.bdqn.agentSystem.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdqn.agentSystem.pojo.Account;
import com.bdqn.agentSystem.pojo.User;
import com.bdqn.agentSystem.service.AccountService;
import com.bdqn.agentSystem.service.UserService;
import com.bdqn.agentSystem.util.MD5;

@Controller
public class UserController {
	Logger log = Logger.getLogger(UserController.class);
	@Resource
	UserService userService;
	
	@Resource
	AccountService accountService;

	@RequestMapping("/")
	public String index(User user) {
		return "login";
	}

	@RequestMapping("login.action")
	public String login(User user,HttpSession session) {
		User loginuser = null;
		try {
			user.setUserPassword(MD5.MD5Encode(user.getUserPassword()));
			log.debug("------>user:" + user.getUserName() + "," + user.getUserPassword());
			loginuser = userService.login(user);
			if (loginuser == null) {
				return "login";
			}else {
				session.setAttribute("currentUser", loginuser);
				User updateLoginTimeUser = new User();
				updateLoginTimeUser.setId(loginuser.getId());
				updateLoginTimeUser.setLastLoginTime(new Date());
				userService.modifyUser(updateLoginTimeUser);
				updateLoginTimeUser = null;
				log.debug("User login : " + loginuser.getUserCode() + " - " + loginuser.getUserName());
				//this.setFuncList(getFuncByCurrentUser(_user.getRoleId()));
				//logger.error("====================>"+ funcList.size());
				return "redirect:main.action";
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
                System.out.println(user.getUserCode()+","+user.getUserPassword());
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
	public String exit(HttpSession session) {
		try{
			User user = (User) session.getAttribute("currentUser");
			if(user != null && user.getId() > 0){
//				setLog(user,Constants.OPERATE_INFO_USER_LOGOUT_SUCCESS);
				session.invalidate();
				session.removeAttribute("currentUser");
				log.error("User logout : " + user.getUserCode() + " - " + user.getUserName());
				user = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "login";
	}
	
	@RequestMapping("main.action")
	public String main(HttpSession session){
		//查询当前账户的信息，User信息从session中取
		//查询当前的账户的余额信息
		Account account = new Account();
		account.setUserId(((User)session.getAttribute("currentUser")).getId());
		try {
			account = accountService.getAccount(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			account = null;
		}
		return "main";
	}
}
