package com.zun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zun.entity.User;
import com.zun.mapper.UserMapper;

@RestController
public class HelloWorldController {
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/getUser")
	public User getUser(HttpServletRequest request) {
//		User user = new User();
//		user.setUserName("小明");
//		user.setPassword("xxxx");
		User user = userMapper.findByName("小明");
//		HttpSession session = request.getSession();
//		session.setAttribute("sessionSign", "aa");
		return user;
	}
}
