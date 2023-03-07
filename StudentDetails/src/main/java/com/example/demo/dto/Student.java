package com.example.demo.dto;

public class Student {

	private int id;  
	private String studentName;  
	private int batchYear; 
	
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
	public int getBatchYear() {
		return batchYear;
	}
	public void setBatchYear(int batchYear) {
		this.batchYear = batchYear;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String email;  
	private String address;  
	//default constructor  
	public Student(int id, String studentName, int batchYear, String email, String address)   
	{  
	super();  
	this.id = id;  
	this.studentName = studentName;  
	this.batchYear = batchYear;  
	this.email = email;  
	this.address = address;  
	}   
}
