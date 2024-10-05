package com.springboot.myhospital.service;

import java.util.Optional;
import java.util.Random;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.myhospital.entity.Appointment;
import com.springboot.myhospital.repository.AppointmentDao;


@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentDao appointmentDao;
	
	@Override
	public Appointment insert(Appointment appointment) {
		List<Integer> ids= this.viewsIds();
		Random random=new Random();
		int id;
		while(true) {
			id=random.nextInt(1000,9999);
			if(!ids.contains(id)) {
				break;
			}
		}
		appointment.setId(id);
		return this.appointmentDao.save(appointment);
	}

	@Override
	public List<Appointment> viewAll() {
		return this.appointmentDao.findAll();
	}

	@Override
	public List<Integer> viewsIds() {

		return this.appointmentDao.viewsIds();
	}

	@Override
	public List<Appointment> viewsUsername(String username) {

		return this.appointmentDao.findByUsername(username);
	}

	@Override
	public Appointment viewId(int id) {
		Optional<Appointment> opt=this.appointmentDao.findById(id);
		if(opt.isEmpty()) {
			return null;
		}	
		return opt.get();
	}

	@Transactional
	@Override
	public int updateStatus(int id,String status) {
		return this.appointmentDao.updateStatus(id,status);
	}

	@Override
	public List<Appointment> viewsAppointmentDate(String date) {
		return this.appointmentDao.findByAppointmentDate(date);
	}

}
