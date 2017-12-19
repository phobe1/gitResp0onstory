package com.bdqn.agentSystem.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bdqn.agentSystem.domain.UserMappper;
import com.bdqn.agentSystem.pojo.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	UserMappper userMapper;
	@Override
	public User login(User user) {
		return userMapper.login(user);
	}
	@Override
	public int isExitLoginUser(User user) throws Exception {
		System.out.println(user);
		return userMapper.isExitLoginUser(user);
	}
	@Override
	public int modifyUser(User user) throws Exception {
		
		return userMapper.modifyUser(user);
	}

}
