package com.springboot.myhospital.repository;

import java.util.List;
import java.util.TreeSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.myhospital.entity.Admin;
import com.springboot.myhospital.entity.Doctor;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Integer> {
	
	@Query(value = "select id from doctors",nativeQuery = true)
	public List<Integer> viewsIds() ;
	
	public Admin findByEmail(String email);
	
	@Query(value = "select d.specialization from doctors d",nativeQuery = true)
	public TreeSet<String> viewsSpecializations() ;
	
	public List<Doctor> findBySpecialization(String specialization) ;
}
