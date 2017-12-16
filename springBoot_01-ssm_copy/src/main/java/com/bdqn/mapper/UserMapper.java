package com.bdqn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bdqn.model.User;

//@CacheConfig(cacheNames="usersAll") 
@Repository
@Mapper
public interface UserMapper {
	@Cacheable(value="user", keyGenerator="redisKeyGenerator")
   User findById(int id);  
   
   @Cacheable(value = "user",keyGenerator="redisKeyGenerator")
   public List<User> queryUserList();
   
   public User queryUserByUserCode(@Param("userCode")String UserCode);
   
   @Transactional(propagation=Propagation.REQUIRED)
   public int addUser(User user);
   
   
   @CacheEvict(value="user",allEntries =true, beforeInvocation=true,keyGenerator="redisKeyGenerator")
   @Transactional(propagation=Propagation.REQUIRED)
   public void deleteUser(@Param("id")int id);
   
   @Transactional(propagation=Propagation.REQUIRED)
  public void updateUser(User user);
   
   
}
