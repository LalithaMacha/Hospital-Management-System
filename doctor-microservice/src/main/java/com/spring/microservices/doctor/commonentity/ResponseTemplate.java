package com.spring.microservices.doctor.commonentity;

import java.util.List;

import com.spring.microservices.doctor.entity.Doctor;

public class ResponseTemplate {
	
	private Doctor doctor;
	
	private List<Patient> patients;

	public ResponseTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseTemplate(Doctor doctor, List<Patient> patients) {
		super();
		this.doctor = doctor;
		this.patients = patients;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	
}
