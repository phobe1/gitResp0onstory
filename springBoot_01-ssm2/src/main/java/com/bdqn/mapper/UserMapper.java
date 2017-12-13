package com.bdqn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bdqn.model.User;

@Repository
@Mapper
public interface UserMapper {
	/*
	 * 根据id查询用户
	 */
   public User findById(int id);  
   /*
    * 查询全部用户信息
    */
   public List<User> queryUserList();
   
   /*
    * 新增用户
    */
   @Transactional(propagation=Propagation.REQUIRED)
   public int addUser(User user);
   
   /*
    * 修改用户信息
    */
   @Transactional(propagation=Propagation.REQUIRED)
   public int updateUser(User user);
   /*
    * 根据id删除用户信息
    */
   @Transactional(propagation=Propagation.REQUIRED)
   public int deleteUserById(@Param("userId")int id);
}
