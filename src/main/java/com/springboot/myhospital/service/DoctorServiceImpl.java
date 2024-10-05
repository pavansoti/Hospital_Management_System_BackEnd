package com.springboot.myhospital.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.myhospital.entity.Doctor;
import com.springboot.myhospital.repository.DoctorDao;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	
	@Override
	public Doctor insert(Doctor doctor) {
		List<Integer> ids= this.viewsIds();
		Random random=new Random();
		int id;
		while(true) {
			id=random.nextInt(1000,9999);
			if(!ids.contains(id)) {
				break;
			}
		}
		doctor.setId(id);
		return this.doctorDao.save(doctor);
	}

	@Override
	public List<Integer> viewsIds() {
		
		return this.doctorDao.viewsIds();
	}

	@Override
	public List<Doctor> views() {
		
		return this.doctorDao.findAll();
	}

	@Override
	public Doctor view(int id) {
		
		Optional<Doctor> opt=this.doctorDao.findById(id);
		if(opt.isEmpty())
			return null;
		return opt.get();
	}

	@Override
	public String delete(int id) {
		
		Optional<Doctor> opt=this.doctorDao.findById(id);
		if(opt.isEmpty())
			return "0";
		this.doctorDao.deleteById(id);
		return "1";
	}

	@Override
	public Doctor update(int id, Doctor doctor) {

		Optional<Doctor> opt=this.doctorDao.findById(id);
		if(opt.isEmpty())
			return null;
		Doctor existDoctor=opt.get();
		if(doctor.getName()!=null)
			existDoctor.setName(doctor.getName());
		if(doctor.getEmail()!=null)
			existDoctor.setEmail(doctor.getEmail());
		if(doctor.getContact()!=0)
			existDoctor.setContact(doctor.getContact());
		if(doctor.getSpecialization()!=null)
			existDoctor.setSpecialization(doctor.getSpecialization());
		if(doctor.getExperience()!=0)
			existDoctor.setName(doctor.getName());
		if(doctor.getDob()!=null)
			existDoctor.setDob(doctor.getDob());
		if(doctor.getAddress()!=null)
			existDoctor.setAddress(doctor.getAddress());		
		return this.doctorDao.save(existDoctor);
	}

	@Override
	public TreeSet<String> viewsSpecializations() {

		return this.doctorDao.viewsSpecializations();
	}

	@Override
	public List<Doctor> viewsSpecialization(String specialization) {

		return this.doctorDao.findBySpecialization(specialization);
	}

}
