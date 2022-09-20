package com.spring.micro.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayPracticeApplication.class, args);
	}

}
