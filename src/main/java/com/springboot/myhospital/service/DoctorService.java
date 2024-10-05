package com.springboot.myhospital.service;

import java.util.List;
import java.util.TreeSet;

import com.springboot.myhospital.entity.Doctor;
import com.springboot.myhospital.entity.User;

public interface DoctorService {
	
	public Doctor insert(Doctor doctor);
	
	public List<Doctor> views();
	
	public List<Integer> viewsIds() ;
	
	public Doctor view(int id);
	
	public String delete(int id);
	
	public Doctor update(int id,Doctor doctor); 

	public TreeSet<String> viewsSpecializations();
	
	public List<Doctor> viewsSpecialization(String specialization);

}
