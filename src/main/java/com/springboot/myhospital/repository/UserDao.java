package com.springboot.myhospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.myhospital.entity.User;



@Repository
public interface UserDao extends JpaRepository<User, String>{

	public User findByEmail(String email);
	
	public User findByUsernameAndPassword(String username,String password);
}
