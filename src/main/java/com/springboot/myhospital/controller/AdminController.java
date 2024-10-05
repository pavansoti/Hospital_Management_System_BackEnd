package com.springboot.myhospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.myhospital.entity.Admin;
import com.springboot.myhospital.service.AdminService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/insert")
	public String insert(@RequestBody Admin admin) {
		return this.adminService.insert(admin);
	}
	
	@PostMapping("/login")
	public Admin confirmAdmin(@RequestBody Admin admin){
		return this.adminService.confirmAdmin(admin);
	}
	
	@PutMapping("/change/{newPassword}")
	public Admin change(@RequestBody Admin admin,@PathVariable("newPassword") String password) {
		
		return this.adminService.changePassword(admin, password);
	}
	
	@DeleteMapping("/delete/{id}")//username or email
	public String delete(@PathVariable("id") String id) {
		
		return this.adminService.delete(id);
	}
	
}
