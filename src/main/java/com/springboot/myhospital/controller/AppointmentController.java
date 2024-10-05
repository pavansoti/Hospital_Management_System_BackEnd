package com.springboot.myhospital.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.myhospital.entity.Appointment;
import com.springboot.myhospital.service.AppointmentService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/insert")
	public Appointment insert(@RequestBody Appointment appointment) {
		return this.appointmentService.insert(appointment);
	}
	
	@GetMapping("/views/{username}")
	public List<Appointment> viewsUsername(@PathVariable("username") String username){
		return this.appointmentService.viewsUsername(username);
	}
	
	@GetMapping("/view/{id}")
	public Appointment viewId(@PathVariable("id") int id){
		return this.appointmentService.viewId(id);
	}
	
	@GetMapping("/update_status/{id}/{status}")
	public int updateStatus(@PathVariable("id") int id,@PathVariable("status") String status){
		return this.appointmentService.updateStatus(id,status);
	}
	
	@GetMapping("/views")
	public List<Appointment> views(){
		return this.appointmentService.viewAll();
	}
	
	@GetMapping("/views_date/{date}")
	public List<Appointment> viewsAppointmentDate(@PathVariable("date") String date){
		return this.appointmentService.viewsAppointmentDate(date);
	}
}
