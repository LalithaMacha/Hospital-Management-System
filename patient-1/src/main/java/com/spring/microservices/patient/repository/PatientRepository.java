package com.spring.microservices.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.microservices.patient.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
