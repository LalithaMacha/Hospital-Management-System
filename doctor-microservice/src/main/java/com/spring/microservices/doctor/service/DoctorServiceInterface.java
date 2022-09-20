package com.spring.microservices.doctor.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.spring.microservices.doctor.commonentity.ResponseTemplate;
import com.spring.microservices.doctor.entity.Doctor;

@Service
public interface DoctorServiceInterface {
	
	public Doctor createDoctor(Doctor doc);
	public List<Doctor> getDoctors();
	public Doctor getDoctor(int id);
}
