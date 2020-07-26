package com.onava006.mvc;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String first_name;
	String last_name;
	Long manager_id;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date created_at;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date updated_ad;

	@ManyToMany
	@JoinTable(name="employees_manager", 
	joinColumns = @JoinColumn(name = "employee_id"), 
	inverseJoinColumns = @JoinColumn(name = "manager_id"))
	List<Employee> employees;
	
	@ManyToMany
	@JoinTable(name="employees_manager",
	joinColumns=@JoinColumn(name="manager_id"),
	inverseJoinColumns=@JoinColumn(name="employee_id"))
	List<Employee> manager;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Long getManager_id() {
		return manager_id;
	}

	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager.add(manager);
	}

	public Long getId() {
		return id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public Date getUpdated_ad() {
		return updated_ad;
	}
	
	





	

}
