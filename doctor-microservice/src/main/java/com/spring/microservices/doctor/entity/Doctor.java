package com.spring.microservices.doctor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor_table")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	@Column
	private String gender;
	
	@Column
	private String specialistField;
	
	@Column
	private int patientId;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(int id, String name, int age, String gender, String specialistField,int patientId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialistField = specialistField;
		this.patientId=patientId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialistField() {
		return specialistField;
	}

	public void setSpecialistField(String specialistField) {
		this.specialistField = specialistField;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	
	
}
