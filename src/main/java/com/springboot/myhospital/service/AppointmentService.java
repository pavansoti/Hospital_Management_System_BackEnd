package com.springboot.myhospital.service;

import java.util.List;

import com.springboot.myhospital.entity.Appointment;

public interface AppointmentService {

	public Appointment insert(Appointment appointment);
	
	public List<Appointment> viewAll();

	public List<Integer> viewsIds();
	
	public List<Appointment> viewsUsername(String username);
	
	public Appointment viewId(int id);
	
	public int updateStatus(int id,String status);

	public List<Appointment> viewsAppointmentDate(String date);
}
