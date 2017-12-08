package com.open.ssm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import com.open.ssm.model.User;

@Repository
@Mapper
public interface UserMapper {
	
	User findById(@Param("userCode") String code,@Param("userPwd") String pwd);
	
	Integer updateUser(@Param("userName")String userName, @Param("userCode")String userCode);
}
