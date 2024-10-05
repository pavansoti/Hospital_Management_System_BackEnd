package com.springboot.myhospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.myhospital.entity.Admin;
import com.springboot.myhospital.entity.User;

@Repository
public interface AdminDao extends JpaRepository<Admin, String>{
	
	public Admin findByEmail(String email);
	
	public Admin findByUsernameAndPassword(String username, String password);
	
	public Admin deleteByEmail(String id);

}
