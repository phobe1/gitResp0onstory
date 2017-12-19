package com.bdqn.agentSystem.service;

import org.springframework.stereotype.Service;

import com.bdqn.agentSystem.pojo.User;

public interface UserService {
	public User login(User user);
	public int isExitLoginUser(User user) throws Exception;
	public int modifyUser(User user) throws Exception;

}
