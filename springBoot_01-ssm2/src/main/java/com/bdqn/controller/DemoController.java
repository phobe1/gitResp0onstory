package com.bdqn.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdqn.mapper.UserMapper;
import com.bdqn.model.User;

@Controller
public class DemoController {
	Logger log = Logger.getLogger(DemoController.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/hello")
	public String main(Model model) {
		model.addAttribute("name", "spring Boot");
		model.addAttribute("count", 8);
//		model.addAttribute("aaa", "test");
//		
		List<User> list = new ArrayList<User>();
		User user1 = new User(1, "aaa", "111");
		User user2 = new User(2, "bbb", "222");
		User user3 = new User(3, "ccc", "333");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		model.addAttribute("users", list);
		model.addAttribute("role", "admin");
		model.addAttribute("role1", "dev");
		model.addAttribute("role2", "tom");
		return "test";
	}
	
	@RequestMapping("queryUserList")
	public String queryUserList(Model model) {
		List<User> list = new ArrayList<User>();
		try {
			list = userMapper.queryUserList();
			model.addAttribute("userList", list);
			return "userList";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping("addUser")
	public String addUser(User user) {
		return "addUser";
	}
	
	@RequestMapping("addUserAction")
	public String addUserAction(User user) {
		int i = 0;
		try {
			user.setCreateDate(new Date());
			i=userMapper.addUser(user);
			log.debug("----->新增的用户条数："+i);
			return "redirect:/queryUserList";
		} catch (Exception e) {
            e.printStackTrace();
            return "error";
		}
		
	}
	
	@RequestMapping("/deleteUserById/{id}")
	public String deleteUserById(@PathVariable("id")int id) {
		int i = 0;
		try {
			i = userMapper.deleteUserById(id);
			return "redirect:/queryUserList";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping("updateUser/{id}")
	public String updateUser(@PathVariable("id")int id,Model model) {
		User user = null;
		try {
			user = userMapper.findById(id);
			model.addAttribute("user",user);
			return "updateUser";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	@RequestMapping("updateUserAction")
	public String updateUserAction(User user) {
		int i = 0;
		try {
			i = userMapper.updateUser(user);
			return "redirect:queryUserList";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	
	
	

}
