package com.onava006.mvc.Models;

import java.util.List;

import javax.persistence.*;
import com.onava006.mvc.Models.Student;

@Entity
@Table(name="dorms")
public class Dorm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@OneToMany(targetEntity=Student.class, mappedBy="dorm", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Student> students;

	public Dorm() {}

	public Dorm(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Student student) {
		this.students.add(student);
	}
	public Long getId() {
		return this.id;
	}
}
