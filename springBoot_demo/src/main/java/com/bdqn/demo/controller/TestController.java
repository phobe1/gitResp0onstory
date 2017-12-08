package com.bdqn.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdqn.demo.mapper.UserMapper;
import com.bdqn.demo.model.User;

@Controller
public class TestController {
	
	@Autowired
	UserMapper userMapper;

	@RequestMapping("/index")
	@ResponseBody
	public User index() {
		System.out.println("-----------------------");
		User user = userMapper.findById(1);
		System.out.println(user);
		return user;
	}
	
	
}
