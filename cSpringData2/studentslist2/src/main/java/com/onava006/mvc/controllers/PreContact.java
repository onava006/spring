package com.onava006.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.onava006.mvc.Models.Student;
import com.onava006.mvc.services.StudentService;

public class PreContact {

	@Autowired
	StudentService service;


	String city;
	String state; 
	String address; 
	Long student_id;	

	Student student;

	public PreContact() {

	}
	public PreContact(String city, String state, String address, Long student_id) {
		
		this.city = city;
		this.state = state;
		this.address = address;
		this.student_id = student_id;
	}
	public StudentService getService() {
		return service;
	}
	public void setService(StudentService service) {
		this.service = service;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	public Student getStudent() {
		return student;
	}

}
