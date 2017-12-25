package com.bdqn.agentSystem.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.bdqn.agentSystem.pojo.User;

@Mapper
@Repository
public interface UserMapper {
//	@Select("select * from as_user where usercode =#{userCode} and userPassword = #{userPassword}")
	public User login(User user);
	
//	@Select("select count(*) from as_user where userCode = #{userCode}")
//	@ResultType(Integer.class)
	public int isExitLoginUser(User user);
	
	
	
	public int modifyUser(User user) throws Exception;
}
