package com.bdqn.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.bdqn.demo.model.User;


@Repository
@Mapper
public interface UserMapper {
   User findById(int id);  
}
