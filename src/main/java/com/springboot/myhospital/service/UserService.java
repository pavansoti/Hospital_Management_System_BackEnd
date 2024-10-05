package com.springboot.myhospital.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.myhospital.entity.User;

public interface UserService {

	public String insert(User user);

	public List<User> views();
	
	public User viewUsername(String username);
	
	public User viewEmail(String email);
	
	public User findByUsernameAndPassword(String username,String password);
	
	public User changePassword(User user,String password);
	
	public User confirmUser(User user);
	
	public User forgetPassword(String id);
	
	public User resetPassword(User user);
	
}
