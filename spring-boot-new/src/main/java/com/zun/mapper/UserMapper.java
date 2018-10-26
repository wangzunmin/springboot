package com.zun.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zun.entity.User;

//@Mapper
public interface UserMapper {
	@Select("SELECT user_name as userName,password FROM user WHERE user_name = #{userName}")
    User findByName(@Param("userName") String userName);

    @Insert("INSERT INTO user(user_name, password) VALUES(#{userName}, #{password})")
    int insert(@Param("userName") String userName, @Param("password") String password);
}
