package com.springboot.myhospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {

	@Id
	private String username;

	private String password;
	
	@Column(unique = true)
	private String email;
	
	private int otp;
}
