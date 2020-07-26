package com.onava006.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onava006.mvc.Models.Student;
import com.onava006.mvc.repositories.StudentRepository;


@Service
public class StudentService {

	@Autowired
	StudentRepository repoStudent;

	public RedirectAttributes createStudent(Student newStudent, RedirectAttributes redirect) {
		redirect.addFlashAttribute("status", "fue creado un nuevo estudiante");
		repoStudent.save(newStudent);
		return redirect;
	}

	public void studentByGet(Student newStudent) {
		repoStudent.save(newStudent);
	}

	public List<Student> getAllStudents(){
		return (List<Student>)repoStudent.findAll();
	}

	public Student findByIdStudent(Long id) {
		Optional<Student> opt =  repoStudent.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}
}
