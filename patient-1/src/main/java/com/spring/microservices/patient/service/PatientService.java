package com.spring.microservices.patient.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.microservices.patient.entity.Patient;
import com.spring.microservices.patient.repository.PatientRepository;

@Service
public class PatientService implements PatientServiceInterface{

	@Autowired
	PatientRepository repo;
	
	@Override
	public Patient createPatient(Patient pat) {
		// TODO Auto-generated method stub
		return repo.save(pat);
	}
	
	@Override
	public List<Patient> getPatients() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	@Override
	public Patient getPatient(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public Patient updatePatient(Patient pat) {
		// TODO Auto-generated method stub
		Patient oldPat=repo.findById(pat.getId()).orElse(null);
		oldPat.setId(pat.getId());
		oldPat.setName(pat.getName());
		oldPat.setVisitedDoctor(pat.getVisitedDoctor());
		oldPat.setDateOfVisit(pat.getDateOfVisit());
		return repo.save(oldPat);	
	}

	@Override
	public void deletePatient(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	


}
