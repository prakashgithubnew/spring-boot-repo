package com.example.demo.dto;

public class Academics {

	private int id;  
	private String studentName;  
	private int yearOfAdmission; 
	private String courseName; 
	private String collegeName; 
	
	//default constructor  
	public Academics(int id, String studentName, int yearOfAdmission, String courseName, String collegeName)   
	{  
	super();  
	this.id = id;  
	this.studentName = studentName;  
	this.yearOfAdmission = yearOfAdmission;  
	this.courseName = courseName;  
	this.collegeName = collegeName;  
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

	public int getYearOfAdmission() {
		return yearOfAdmission;
	}

	public void setYearOfAdmission(int yearOfAdmission) {
		this.yearOfAdmission = yearOfAdmission;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}   
}
