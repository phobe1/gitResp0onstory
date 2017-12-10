package com.bdqn.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdqn.mapper.UserMapper;
import com.bdqn.model.User;

@Controller
public class DemoController {
	Logger log = Logger.getLogger(DemoController.class);

	@Autowired
	UserMapper userMapper;

	@RequestMapping("/hello")
	public String main(Model model) {
		model.addAttribute("name", "spring Boot");
		model.addAttribute("count", 8);
		model.addAttribute("aaa", "test");

		List<User> list = new ArrayList<User>();
		User user1 = new User(1, "aaa", "111");
		User user2 = new User(2, "bbb", "222");
		User user3 = new User(3, "ccc", "333");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		model.addAttribute("users", list);
		model.addAttribute("role", "tom");
		return "hello";
	}

	@RequestMapping("userList")
	public String queryUserList(Model model,HttpSession session) {
		model.addAttribute("userList", userMapper.queryUserList());
		session.setAttribute("aaa", "aaa,hello");
		return "userlist";
	}
	
	@RequestMapping("addUserhtml")
	public String addUserhtml(User user) {
		
		return "addUser";

	}

	@RequestMapping("addUser")
	public String addUser(User user) {
		int i = 0;
		try {
			System.out.println(user.toString());
			user.setCreateDate(new Date());
			i = userMapper.addUser(user);
			log.debug("i------>"+i);
			System.out.println("i------>"+i);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:/userList";

	}
	
	@RequestMapping("deleteUser/{id}")
	public String deleteUser(@PathVariable(name="id")int id) {
		try {
			userMapper.deleteUser(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:/userList";

	}
	
	@RequestMapping(value="findUserById/{id}",method=RequestMethod.GET)
	public String findUserById(@PathVariable(name="id")int id,Model model) {
		System.out.println("------------------>");
		User user = userMapper.findById(id);
		System.out.println(user);
		model.addAttribute("user",user);
		return "modifyUser";
	}
	
	@RequestMapping(value="modifyUser")
	public String modifyUser(User user) {
		try {
			log.info("----------------");
			userMapper.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
			return "error";
		}
		return "redirect:/userList";
	}
	
	@RequestMapping("queryUserByUserCode")
	@ResponseBody
	public Map queryUserByUserCode(@RequestParam("userCode")String userCode) {
		User user = userMapper.queryUserByUserCode(userCode);
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(user);
		log.debug("-------------------------");
		System.out.println(userCode);
		if(user!=null&&user.getUserCode()!=null) {
			map.put("result", "NO");
		}else{
			map.put("result", "YES");
		}
		return map;
	}
	

}
