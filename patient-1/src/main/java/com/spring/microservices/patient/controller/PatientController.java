package com.spring.microservices.patient.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservices.patient.entity.Patient;
import com.spring.microservices.patient.service.PatientService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/pat")
public class PatientController {
	
	@Autowired
	PatientService service;
	
	@PostMapping("/post")
	public Patient createpatient(@RequestBody Patient pat) {
		return service.createPatient(pat);
	}
	
	@GetMapping("/get")
	public List<Patient> getpatients(){
		return service.getPatients();
	}
	
	@GetMapping("/get/{id}")
	public Patient getpatient(@PathVariable int id) {
		return service.getPatient(id);
	}
	
	@PutMapping("/update")
	public Patient updatepatient(@RequestBody Patient pat) {
		return service.updatePatient(pat);
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> deletepatient(@PathVariable int id){
		service.deletePatient(id);
		return new ResponseEntity<String>("Patient record deleted successfully",HttpStatus.OK);
	}
		
}
