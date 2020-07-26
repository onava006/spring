package com.onava006.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onava006.mvc.Models.Dorm;
//import com.onava006.mvc.Models.Dorm;
import com.onava006.mvc.Models.Student;
import com.onava006.mvc.controllers.PreStudentDorm;
import com.onava006.mvc.repositories.DormRepository;
import com.onava006.mvc.repositories.StudentRepository;


@Service
public class StudentService {

	@Autowired
	StudentRepository repoStudent;
	@Autowired
	DormRepository repoDorm;
	@Autowired
	DormService dormService;

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
	
	public List<Student> getAllStudentsFromDorm(Long id){
		return (List<Student>)repoStudent.findByDorm_id(id);
	}
	
	
	
	public Student findByIdStudent(Long id) {
		Optional<Student> opt =  repoStudent.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}
	public Iterable<Student> getAllNullDormStudents(){
		return repoStudent.findByDorm_idIsNull();
	}

	public RedirectAttributes setDorm(PreStudentDorm studentToDorm, Dorm dorm, RedirectAttributes state) {
		Optional<Student> opt = repoStudent.findById(studentToDorm.getStudent_id());
		if(opt.isPresent()) {
			Student student = opt.get();
			student.setDorm(dorm);		
			repoStudent.save(student);
			state.addFlashAttribute("status","Funciona pero no sabemos porque no agrega");
		} else {
			state.addFlashAttribute("status", "no se pudo agregar el dorm");
		}		
		return state;
	}

	public RedirectAttributes deleteFromDorm(Long dormId, Long studentId, RedirectAttributes redirect) {

		Student student;
		Optional<Student> opt = repoStudent.findById(studentId);
		if(opt.isPresent()) {
			student = opt.get();	
			Dorm dormStudent = student.getDorm();
			Dorm checkDorm;
			Optional<Dorm> optDorm = repoDorm.findById(dormId);
			if(optDorm.isPresent()) {
				checkDorm = optDorm.get();
			} else {
				return null;
			}
			if(dormStudent.getId().equals(checkDorm.getId())) {
				student.setDorm(null);
				repoStudent.save(student);
			}				
		} else {
			redirect.addFlashAttribute("status", "el estudiante no existe");
		}
		return redirect;
	}

}
























