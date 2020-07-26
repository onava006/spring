package com.onava006.mvc.Models;

import javax.persistence.*;

@Entity
@Table(name="Contact")
public class ContactInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String adress;
	private String city;
	private String state;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id")
	Student student;		
	
	public ContactInfo() {}
	
	public ContactInfo(String adress, String city, String state, Student student) {	
		this.adress = adress;
		this.city = city;
		this.state = state;
		this.student = student;
	}
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Long getId() {
		return id;
	}

}
