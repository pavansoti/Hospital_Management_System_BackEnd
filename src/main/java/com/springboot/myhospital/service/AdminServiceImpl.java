package com.springboot.myhospital.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.myhospital.entity.Admin;
import com.springboot.myhospital.entity.User;
import com.springboot.myhospital.repository.AdminDao;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public String insert(Admin admin) {
		
		if(this.viewUsername(admin.getUsername())!=null) {
			return "1";
		}else if(this.viewEmail(admin.getEmail())!=null) {
			return "2";
		}
		this.adminDao.save(admin);
		return "3";
	}

	@Override
	public Admin viewUsername(String username) {
		Optional<Admin> opt=this.adminDao.findById(username);
		if(opt.isEmpty())
			return null ;
		return opt.get();
	}

	@Override
	public Admin viewEmail(String email) {
		
		return this.adminDao.findByEmail(email);
	}

	@Override
	public Admin findByUsernameAndPassword(String username, String password) {
		
		return this.adminDao.findByUsernameAndPassword(username, password);
	}

	@Override
	public Admin confirmAdmin(Admin admin) {
		Admin databaseUser=this.viewUsername(admin.getUsername());
		if(databaseUser!=null) {
			if(admin.getPassword().equals(databaseUser.getPassword()))
				return databaseUser;
			else
				return null;
		}
		else 
			return null;
	}

	@Override
	public Admin changePassword(Admin admin, String password) {
		Admin databaseAdmin=this.findByUsernameAndPassword(admin.getUsername(), admin.getPassword());
		if(databaseAdmin!=null) {
			databaseAdmin.setPassword(password);
			return this.adminDao.save(databaseAdmin);
		}
		else 
			return null;
	}

	@Override
	public String delete(String id) {
		
		Optional<Admin> opt=this.adminDao.findById(id);
		Admin admin=this.adminDao.findByEmail(id);
		if(opt.isEmpty()&&admin==null) {
			return null;
		}else if(admin!=null) {
			this.adminDao.deleteByEmail(id);
			return "1";
		}else {
			this.adminDao.deleteById(id);
			return "1";
		}
	}
}
