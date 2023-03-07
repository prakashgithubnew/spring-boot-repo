package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.Employment;



@RestController
public class EmploymentDetailsController {

		
	
	   
	   @RequestMapping(value = "/employment")
	   public List<Employment> getEmploymentDetails() {
		   
		   try {
			   System.out.println("Insde EmploymentDetailsController ,getEmploymentDetails Method");
		   
		    }catch(Exception e) {
			  System.out.println("error occurred");
		   }
		   return getEmploymentData();
		   }

	private List<Employment> getEmploymentData() {
		ArrayList<Employment> employment = new ArrayList<Employment>();  
		//adding products to the List  
		System.out.println("Insde getEmploymentData Method");
		employment.add(new Employment(1, "Matthew Jones", 2005, "Barclays UK LTD", "Senior Consultant"));  

		//returns a list of students  
		return employment;

	}


}
