package com.spring.microservices.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservices.doctor.commonentity.ResponseTemplate;
import com.spring.microservices.doctor.entity.Doctor;
import com.spring.microservices.doctor.service.DoctorService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService service;
	
	@PostMapping("/post")
	public Doctor createdoctor(@RequestBody Doctor doc) {
		return service.createDoctor(doc);
	}
	
	@GetMapping("/get")
	public List<Doctor> getdoctors(){
		return service.getDoctors();
	}
	
	@GetMapping("/get/{id}")
	public Doctor getDoctor(@PathVariable int id) {
		return service.getDoctor(id);
	}
	
	@GetMapping("/patients/{id}")
	public ResponseTemplate getAllPatientDoctorinfo(@PathVariable int id){
		return service.getAllPatientDoctorinfo(id);
		
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deletepatient(@PathVariable int id){
		service.deletePatient(id);
		return new ResponseEntity<String>("doctor record deleted successfully",HttpStatus.OK);
	}
	
	
	
}
