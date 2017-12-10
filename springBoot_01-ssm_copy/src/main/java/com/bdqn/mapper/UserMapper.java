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
   User findById(int id);  
   
   public List<User> queryUserList();
   
   public User queryUserByUserCode(@Param("userCode")String UserCode);
   
   @Transactional(propagation=Propagation.REQUIRED)
   public int addUser(User user);
   
   @Transactional(propagation=Propagation.REQUIRED)
   public void deleteUser(@Param("id")int id);
   
   @Transactional(propagation=Propagation.REQUIRED)
  public void updateUser(User user);
   
   
}
