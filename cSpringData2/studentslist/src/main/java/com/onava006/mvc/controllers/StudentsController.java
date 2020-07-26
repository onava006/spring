package com.onava006.mvc.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onava006.mvc.Models.ContactInfo;
import com.onava006.mvc.Models.Student;
import com.onava006.mvc.services.ContactService;
import com.onava006.mvc.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentsController {
	@Autowired
	StudentService studentService;	
	@Autowired
	ContactService contactService; 
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newStudent(@ModelAttribute("newStudent") Student student) {		
		return "newStudent.jsp";		
	}
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String showContacts(Model model) {
		List<ContactInfo> contacts = (List<ContactInfo>)contactService.getAllContacts();
		model.addAttribute("contacts", contacts);		
		return "showContacts.jsp";
	} 
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createStudentByGet(
			@Valid @ModelAttribute("newStudent") Student studentByGet,
			BindingResult result,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("age") Integer age,
			RedirectAttributes redirect
			)
	{
		if(result.hasErrors()) {
			redirect.addFlashAttribute("status", "hubo un error intentando crear el usuario");
		} else {
		studentByGet = new Student(firstName, lastName, age);			
		redirect = studentService.createStudent(studentByGet, redirect);		
		}
		return "redirect:/students/new";
		
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createStudentByPost(
			@Valid @ModelAttribute("newStudent") Student studentByPost,
			BindingResult result,
			RedirectAttributes redirect
			)
	{
		if(result.hasErrors()) {
			redirect.addFlashAttribute("status", "hubo un error intentando crear el usuario");
		} else {		
		redirect = studentService.createStudent(studentByPost, redirect);		
		}
		return "redirect:/students/new";
		
	}
}

