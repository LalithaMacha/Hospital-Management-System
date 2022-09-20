package com.spring.microservices.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Patient1Application {

	public static void main(String[] args) {
		SpringApplication.run(Patient1Application.class, args);
	}

}
