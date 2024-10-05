package com.springboot.myhospital.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.myhospital.entity.User;
import com.springboot.myhospital.service.UserService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/insert")
	public String insert(@RequestBody User user){	

		return this.userService.insert(user);
	}
	 
	@GetMapping("/views")
	public List<User> views(){
		return this.userService.views();
	}	
	
	@PostMapping("/login")
	public User confirmUser(@RequestBody User user){
		return this.userService.confirmUser(user);
	}
	 
	@PutMapping("/change/{newPassword}")
	public User change(@RequestBody User user,@PathVariable("newPassword") String password) {
		return this.userService.changePassword(user, password);
	}	
	
	@GetMapping("/forget_password/{id}")
	public User forgetPassword(@PathVariable("id") String id){//username or email
		return this.userService.forgetPassword(id);
	}
	
	@PostMapping("/reset_password")
	public User resetPassword(@RequestBody User user) {
		return this.userService.resetPassword(user);
	}
	
	@GetMapping("/feedback/{username}")
	public User view(@PathVariable("username") String username) {
		return this.userService.viewUsername(username);
	}
	
}
