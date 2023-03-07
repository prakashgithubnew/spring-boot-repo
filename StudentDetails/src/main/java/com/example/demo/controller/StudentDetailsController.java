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

import com.example.demo.dto.Student;

@RestController
public class StudentDetailsController {

	@Autowired(required = true)
	RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/student")
	public List<Object> getStudentOnlyDetails() {

		try {
			System.out.println("Inside StudentDetailsController,  getStudentOnlyDetails Method");

		} catch (Exception e) {
			System.out.println("error occurred");
		}
		return getStudentOnlyData();
	}

	@RequestMapping(value = "/student/academics")
	public List<Object> getStudentAcademicsDetails() {

		try {
			System.out.println("Inside StudentDetailsController, getStudentAcademicsDetails Method");

		} catch (Exception e) {
			System.out.println("error occurred");
		}
		return getStudentAcademicData();
	}

	@RequestMapping(value = "/student/academics/employment")
	public List<Object> getStudentAcademicsEmploymentDetails() {

		try {
			System.out.println("Inside StudentDetailsController , getStudentAcademicsEmploymentDetails Flow");

		} catch (Exception e) {
			System.out.println("error occurred");
		}
		return getStudentAcademicEmploymentData();
	}

	private List<Object> getStudentOnlyData() {
		System.out.println("Inside getStudentOnlyData Method");
		ArrayList<Object> objects = new ArrayList<Object>();
		ArrayList<Student> students = new ArrayList<Student>();

		// adding products to the List
		students.add(new Student(1, "Matthew Jones", 2001, "matthewjones@gmail.com", "20 Benbow Street,Manchetser"));

		objects.add(students);

		return objects;

	}

	private List<Object> getStudentAcademicData() {
		System.out.println("Inside getStudentAcademicData Method");
		ArrayList<Object> objects = new ArrayList<Object>();
		ArrayList<Student> students = new ArrayList<Student>();
		// adding products to the List
		students.add(new Student(1, "Matthew Jones", 2001, "matthewjones@gmail.com", "20 Benbow Street,Manchetser"));

		objects.add(getStudentOnlyData());

		Object[] academics = callAcademicApi();

		objects.add(academics);

		return objects;

	}

	private List<Object> getStudentAcademicEmploymentData() {
		System.out.println("Inside getStudentAcademicEmploymentData Method");
		ArrayList<Object> objects = new ArrayList<Object>();
		ArrayList<Student> students = new ArrayList<Student>();
		// adding products to the List
		students.add(new Student(1, "Matthew Jones", 2001, "matthewjones@gmail.com", "20 Benbow Street,Manchetser"));

		objects.add(getStudentOnlyData());
		// Object[] academics = callAcademicEmploymentApi();
		Object[] academicemployment = callAcademicEmploymentApi();

		// objects.add(academics);
		objects.add(academicemployment);
		return objects;

	}

	/**
	 * Call Academic API to fetch Students Academic Record
	 * 
	 * @return
	 */
	public Object[] callAcademicApi() {
		System.out.println("Inside callAcademicApi Method");
		HttpHeaders headers = new HttpHeaders();
		// InetAddress inetAddress = InetAddress.getLocalHost();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:8081/academics", HttpMethod.GET, entity, Object[].class)
				.getBody();
	}

	/**
	 * Call Academic API & Employment API to fetch Students Academic and Employment
	 * Record
	 * 
	 * @return
	 */
	public Object[] callAcademicEmploymentApi() {
		System.out.println("Inside callAcademicEmploymentApi Method");
		HttpHeaders headers = new HttpHeaders();
		// InetAddress inetAddress = InetAddress.getLocalHost();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate
				.exchange("http://localhost:8081/academics/employment", HttpMethod.GET, entity, Object[].class)
				.getBody();
	}

}
