package com.spring.microservices.doctor.commonentity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Patient {
	
	
	@Id
	private int patientId;
	
	@Column
	private String name;
	
	@Column
	private String visitedDoctor;
	
	@Column
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateOfVisit;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(int patientId, String name, String visitedDoctor, Date dateOfVisit) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.visitedDoctor = visitedDoctor;
		this.dateOfVisit = dateOfVisit;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVisitedDoctor() {
		return visitedDoctor;
	}

	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}

	public Date getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public List<Patient> getPatient() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
