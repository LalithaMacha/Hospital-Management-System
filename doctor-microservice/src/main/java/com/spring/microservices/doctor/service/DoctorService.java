package com.spring.microservices.doctor.service;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.spring.microservices.doctor.commonentity.Patient;
import com.spring.microservices.doctor.commonentity.ResponseTemplate;
import com.spring.microservices.doctor.entity.Doctor;
import com.spring.microservices.doctor.repository.DoctorRepository;


@Service
public class DoctorService implements DoctorServiceInterface {

	@Autowired
	DoctorRepository repo;
	
	@Autowired
	private RestTemplate res;
	
	@Override
	public Doctor createDoctor(Doctor doc) {
		// TODO Auto-generated method stub
		return repo.save(doc);
	}

	@Override
	public List<Doctor> getDoctors() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Doctor getDoctor(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}
	
	
	public ResponseTemplate getAllPatientDoctorinfo(int id){
		ResponseTemplate response=new ResponseTemplate();
		Doctor doctor=repo.findById(id).get();
		response.setDoctor(doctor);	
		
		java.util.List<Patient> patient=(List<Patient>) res.getForObject("http://localhost:9393/pat/get/"+doctor.getPatientId(),Patient.class);
	    response.setPatients(patient);
	    return response;
	}
	
	public void deletePatient(int id) {
		repo.deleteById(id);
	}

	
	}
