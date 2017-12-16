package com.bdqn.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
protected static Logger logger=Logger.getLogger(UserController.class); 
	
	StringRedisTemplate stringRedisTemplate; 
	
	@Resource(name="stringRedisTemplate")  
    ValueOperations<String,String> valOpsStr; 
	
	@RequestMapping("set")  
    public String setKeyAndValue(String key,String value){  
        logger.debug("访问set:key={"+key+"},value={"+value+"}");  
        valOpsStr.set(key, value);  
        return "Set Ok";  
    }  
      
    @RequestMapping("get")  
    public String getKey(String key){  
        logger.debug("访问get:key={"+key+"}");  
        return valOpsStr.get(key);  
    }
	
}
