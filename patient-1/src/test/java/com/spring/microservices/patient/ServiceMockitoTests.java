package com.spring.microservices.patient;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.test.web.servlet.RequestBuilder;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.microservices.patient.controller.PatientController;
import com.spring.microservices.patient.entity.Patient;
import com.spring.microservices.patient.repository.PatientRepository;
import com.spring.microservices.patient.service.PatientService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=PatientController.class)
public class ServiceMockitoTests {
	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	PatientService service;

	
	 @Test
     public void testCreatePatient() throws Exception{
			Patient mockpatient=new Patient();
			mockpatient.setId(1);
			mockpatient.setName("Ani");
			mockpatient.setVisitedDoctor("Dr Karthik");
			mockpatient.setDateOfVisit(new Date(0, 0, 0));
			
			String inputInJson=this.mapToJson(mockpatient);
			
			String URI = "/pat/post";
			
			Mockito.when(service.createPatient(Mockito.any(Patient.class))).thenReturn(mockpatient);
			
			RequestBuilder requestBuilder= MockMvcRequestBuilders
					.post(URI)
					.accept(MediaType.APPLICATION_JSON).content(inputInJson)
					.contentType(MediaType.APPLICATION_JSON);
					
			MvcResult result= mockmvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response=result.getResponse();
			
			String outputInJson=response.getContentAsString();
			
			assertThat(outputInJson).isEqualTo(inputInJson);
			assertEquals(HttpStatus.OK.value(), response.getStatus());
			
		}
		
	    @Test
		public void testgetPatient() throws Exception{
			Patient mockpatient=new Patient();
			mockpatient.setId(1);
			mockpatient.setName("Ani");
			mockpatient.setVisitedDoctor("Dr Karthik");
			mockpatient.setDateOfVisit(new Date(0, 0, 0));
			
			String URI = "/pat/get/1";
			
			Mockito.when(service.getPatient(Mockito.anyInt())).thenReturn(mockpatient);
			
			RequestBuilder requestBuilder= MockMvcRequestBuilders.get(URI)
					.accept(MediaType.APPLICATION_JSON);
					
			MvcResult result= mockmvc.perform(requestBuilder).andReturn();
			
			String expectedJson=this.mapToJson(mockpatient);
			String outputInJson=result.getResponse().getContentAsString();
			
			assertThat(outputInJson).isEqualTo(expectedJson);
			
		}
		
	   private String mapToJson(Object object) throws JsonProcessingException {
		   ObjectMapper objectMapper=new ObjectMapper();
		   return objectMapper.writeValueAsString(object);
	   }
	}
