package com.springboot.myhospital.controller;

import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.myhospital.entity.Doctor;
import com.springboot.myhospital.service.DoctorService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/insert")
	public Doctor insert(@RequestBody Doctor doctor) {
		return this.doctorService.insert(doctor);
	}
	
	@GetMapping("/views")
	public List<Doctor> views(){
		return this.doctorService.views();
	}
	
	@GetMapping("/view/{id}")
	public Doctor view(@PathVariable("id") int id) {
		return this.doctorService.view(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		return this.doctorService.delete(id);
	}
	
	@PatchMapping("/update/{id}")
	public Doctor update(@PathVariable("id") int id,@RequestBody Doctor doctor) {
		return this.doctorService.update(id,doctor);
	}
	
	@GetMapping("/specialization")
	public TreeSet<String> viewsSpecializations(){
		return this.doctorService.viewsSpecializations();
	}
	
	@GetMapping("/specialization/{specialization}")
	public List<Doctor> viewsSpecialization(@PathVariable("specialization") String specialization){
		System.out.println(specialization);
		return this.doctorService.viewsSpecialization(specialization);
	}
	
}
