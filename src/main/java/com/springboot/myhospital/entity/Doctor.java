package com.springboot.myhospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="doctors")
public class Doctor {

	@Id
	private int id;
	
	private String name;
	
	private String specialization;
	
	private int experience;
	
	private long contact;
	
	private String email;
	
	private String address;
	
	private String status;
	
	private String dob;
	/* 
	 * "id":3,
    "doctorId":{
        "id":12,
        "name":"shfiu",
        "specialization":"hsbfvi",
        "experience":2,
        "contact":565,
        "email":"schish",
        "address":"uishdi",
        "dob":"656"
        },
    "username":"pavan",
    "name":"naveen",
    "gender":"male",
    "age":25,
    "mobile":7065959542,
    "address":"hyd",
    "appointmentDate":"2024-06-11",
    "status":"open" */
}