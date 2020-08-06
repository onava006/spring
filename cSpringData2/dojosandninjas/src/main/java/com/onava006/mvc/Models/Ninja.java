package com.onava006.mvc.Models;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="ninja")
public class Ninja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Size(min=2, message="Name must be at least two letters long")
	String firstName;
	String lasName;
	Integer age;
	
	@Transient
	Long dojoId;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	Date createdAt;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	Date updatedAt;
	
	public Ninja() {}
	
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	public void onUpdate(){
		this.updatedAt = new Date();
	}
	@ManyToOne
	@JoinColumn(name="dojo_id")
	Dojo dojo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasName() {
		return lasName;
	}

	public void setLasName(String lasName) {
		this.lasName = lasName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}

	public Long getDojoId() {
		return dojoId;
	}

	public void setDojoId(Long dojoId) {
		this.dojoId = dojoId;
	}
}
