package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.Academics;

@RestController
public class AcademicDetailsController {

	@Autowired(required = true)
	RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/academics")
	public List<Object> getAcademicsDetails() {

		try {
			System.out.println("Insde AcademicDetailsController, getAcademicsDetails Method");

		} catch (Exception e) {
			System.out.println("error occurred");
		}
		return getAcademicsData();
	}

	@RequestMapping(value = "/academics/employment")
	public List<Object> getAcademicsEmploymentDetails() {

		try {
			System.out.println("Insde AcademicDetailsController, getAcademicsEmploymentDetails method");

		} catch (Exception e) {
			System.out.println("error occurred");
		}
		return getAcademicsEmploymentData();
	}

	private List<Object> getAcademicsData() {
		ArrayList<Academics> academics = new ArrayList<Academics>();
		ArrayList<Object> objects = new ArrayList<Object>();
		// adding products to the List
		System.out.println("Insde getAcademicsData Method");
		academics.add(new Academics(1, "Matthew Jones", 2001, "Bachelor in Economics", "Oxford University"));
		objects.add(academics);


		return objects;

	}

	private List<Object> getAcademicsEmploymentData() {
		System.out.println("Insde getAcademicsEmploymentData Method");
		ArrayList<Academics> academics = new ArrayList<Academics>();
		ArrayList<Object> objects = new ArrayList<Object>();

		objects.add(getAcademicsData());

		Object[] employment = callEmploymentApi();
		objects.add(employment);
		// returns a list of students
		return objects;

	}

	public Object[] callEmploymentApi() {
		HttpHeaders headers = new HttpHeaders();
		System.out.println("Insde callEmploymentApi Method");
		// InetAddress inetAddress = InetAddress.getLocalHost();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8082/employment", HttpMethod.GET, entity, Object[].class)
				.getBody();
	}

}
