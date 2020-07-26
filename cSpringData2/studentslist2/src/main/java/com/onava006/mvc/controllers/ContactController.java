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

import com.onava006.mvc.Models.Student;
import com.onava006.mvc.services.ContactService;
import com.onava006.mvc.services.StudentService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	StudentService studentService; 
	@Autowired
	ContactService contactService; 

	@RequestMapping(value="/new", method= RequestMethod.GET)
	public String addContact(
			@ModelAttribute("preContact") PreContact preContact,
			Model model) {		
		List<Student> studentList = studentService.getAllStudents();
		model.addAttribute("students",  studentList);
		return "addContact.jsp";
	}
	
	@RequestMapping(value="/create", method= RequestMethod.POST)
	public String createContactbyPost(
			@Valid @ModelAttribute("preContact") 
			PreContact precontact, 
			RedirectAttributes result, 
			BindingResult status) {

		result = contactService.addContactInfo(result, precontact, status);
		return "redirect:/contact/new";
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createContactByGet(
			@ModelAttribute("preContact") PreContact precontact, 
			BindingResult status,
			@RequestParam("student") Long student_id,
			@RequestParam("address") String address,
			@RequestParam("city") String city,
			@RequestParam("state") String state,
			RedirectAttributes result			
			) {
		precontact = new PreContact(city, state, address,student_id);

		precontact.student = studentService.findByIdStudent(student_id);
		result = contactService.addContactInfo(result, precontact, status);

		return "redirect:/contact/new";
	}









}
