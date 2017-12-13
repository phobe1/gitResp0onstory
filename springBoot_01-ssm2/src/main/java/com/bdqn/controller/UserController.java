package com.bdqn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bdqn.mapper.UserMapper;
import com.bdqn.model.User;

@RestController
public class UserController {

	@Autowired
	UserMapper userMapper;
	@RequestMapping("/main")
	public String main(Model model) {
		model.addAttribute("name", "ssss");
		return "hello";
	}
	
	@RequestMapping("/fid")
	public User findUserById() {
		System.out.println("------------------>");
		User user = userMapper.findById(1);
		return user;
	}
	
	
	
}
