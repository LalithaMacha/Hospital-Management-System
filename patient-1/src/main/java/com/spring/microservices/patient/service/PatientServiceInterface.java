package com.spring.microservices.patient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.microservices.patient.entity.Patient;

@Service 
public interface PatientServiceInterface {
	
	public Patient createPatient(Patient pat);
	public List<Patient> getPatients();
	public Patient getPatient(int id);
	public Patient updatePatient(Patient pat);
	public void deletePatient(int id);

}
