package com.springboot.myhospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="admins")
public class Admin {
	
	@Id
	String username;
	
	String password;
	
	@Column(unique = true)
	String email;
}
