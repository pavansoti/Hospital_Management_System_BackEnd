package com.springboot.myhospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
@Table(name="appointments")
public class Appointment {

	@Id
	private int id;
	
	private String username;
	
	@Column(name="patient_name")
	private String name;
	
	private String gender;
	
	private int age;
	
	private long mobile;
	
	private String address;
	
	@Column(name="appointment_date",length=50)
	private String appointmentDate;
	
	private String status;
	
	@ManyToOne
	private Doctor doctorId;
}
