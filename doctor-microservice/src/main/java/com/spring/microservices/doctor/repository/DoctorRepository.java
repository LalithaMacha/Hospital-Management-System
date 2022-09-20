package com.spring.microservices.doctor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.microservices.doctor.entity.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor,Integer>{

	List<Doctor> findByName(String name);

}
