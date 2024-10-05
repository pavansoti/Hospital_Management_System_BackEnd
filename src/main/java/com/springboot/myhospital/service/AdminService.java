package com.springboot.myhospital.service;

import com.springboot.myhospital.entity.Admin;
import com.springboot.myhospital.entity.User;

public interface AdminService {

	public String insert(Admin admin);

	public Admin viewUsername(String username);
	
	public Admin viewEmail(String email);

	public Admin findByUsernameAndPassword(String username, String password);
	
	public Admin confirmAdmin(Admin admin);
	
	public Admin changePassword(Admin admin,String password);
	
	public String delete(String id);
}
