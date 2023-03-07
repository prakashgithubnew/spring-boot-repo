package com.example.demo.dto;

public class Employment {

	private int id;  
	private String studentName;  
	private int hireYear; 
	private String organisationName; 
	private String designation; 
	
	//default constructor  
	public Employment(int id, String studentName, int hireYear, String organisationName, String designation)   
	{  
	super();  
	this.id = id;  
	this.studentName = studentName;  
	this.hireYear = hireYear;  
	this.organisationName = organisationName;  
	this.designation = designation;  
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getHireYear() {
		return hireYear;
	}

	public void setHireYear(int hireYear) {
		this.hireYear = hireYear;
	}

	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	

	  
}
