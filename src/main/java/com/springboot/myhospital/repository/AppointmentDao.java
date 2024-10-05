package com.springboot.myhospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.myhospital.entity.Appointment;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Integer>{

	@Query(value = "select id from appointments",nativeQuery = true)
	public List<Integer> viewsIds() ;
	
	public List<Appointment> findByUsername(String username);
	
	@Transactional
	@Modifying
	@Query(value="update appointments a set a.status =:status where a.id =:id",nativeQuery = true)
	public int updateStatus(@Param("id") int id,@Param("status") String status);
	
	public List<Appointment> findByAppointmentDate(String date);
}
