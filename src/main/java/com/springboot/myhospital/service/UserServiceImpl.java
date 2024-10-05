package com.springboot.myhospital.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.myhospital.entity.User;
import com.springboot.myhospital.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public String insert(User user) {
		if(this.viewUsername(user.getUsername())!=null) {
			return "1";
		}else if(this.viewEmail(user.getEmail())!=null) {
			return "2";
		}
		this.userDao.save(user);
		return "3";
	}
	
	@Override
	public List<User> views(){
		return this.userDao.findAll();
	}

	@Override
	public User viewUsername(String username) {
		
		Optional<User> opt=this.userDao.findById(username);
		if(opt.isEmpty())
			return null ;
		return opt.get();
	}

	@Override
	public User viewEmail(String email) {
		return this.userDao.findByEmail(email);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return this.userDao.findByUsernameAndPassword(username, password);
	}

	@Override
	public User changePassword(User user, String password) {
		User databaseUser=this.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		if(databaseUser!=null) {
			databaseUser.setPassword(password);
			return this.userDao.save(databaseUser);
		}
		else 
			return null;
	}

	@Override
	public User confirmUser(User user) {
		User databaseUser=this.viewUsername(user.getUsername());
		if(databaseUser!=null) {
			if(user.getPassword().equals(databaseUser.getPassword()))
				return databaseUser;
			else
				return null;
		}
		else 
			return null;
	}

	@Override
	public User forgetPassword(String id) {
		Random random=new Random();
		int otp=random.nextInt(1111,9999);
		User emailUser=this.viewEmail(id);
		User usernameUser=this.viewUsername(id);
		if(emailUser==null&&usernameUser==null) {
			return null;
		}else if(emailUser!=null) {
			emailUser.setOtp(otp);
			this.userDao.save(emailUser);
			return emailUser;
		}else {
			usernameUser.setOtp(otp);
			this.userDao.save(usernameUser);
			return usernameUser;
		}
	}

	@Override
	public User resetPassword(User user) {
		
		return this.userDao.save(user);
	}

}
