package com.kh.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.api.model.vo.User;

import mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	public void register(User user) {
		mapper.register(user);
		System.out.println(user);
	}
	public User login(User user) {
		return mapper.login(user);
	}
	public User kakaoLogin(String email) {
		return mapper.kakaoLogin(email);
	}
}
