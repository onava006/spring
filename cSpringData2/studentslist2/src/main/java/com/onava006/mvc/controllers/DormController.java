package com.onava006.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.onava006.mvc.Models.Dorm;
import com.onava006.mvc.Models.Student;
import com.onava006.mvc.services.DormService;
import com.onava006.mvc.services.StudentService;

@Controller
@RequestMapping("/dorms/")
public class DormController {

	@Autowired
	DormService dormService;
	@Autowired
	StudentService studentService;

	@RequestMapping(value="new", method=RequestMethod.GET)
	public String createDormByGet(
			@ModelAttribute("newDorm") Dorm dorm) {
		return "addDorm.jsp";
	}

	@RequestMapping(value="new", method= RequestMethod.POST)
	public String createDormByPost(
			@Valid @ModelAttribute("newDorm") Dorm dorm, 
			BindingResult result,
			RedirectAttributes redirect) 
	{
		redirect = dormService.AddNewDorm(dorm, result, redirect);		
		return "redirect:/dorms/"+ String.valueOf(dorm.getId())+"/get";
	}

	@RequestMapping(value="{id}/add", method=RequestMethod.POST)
	public String addStudentByPost(
			@Valid @ModelAttribute("newStudent") PreStudentDorm studentToDorm,
			@PathVariable("id") Long id,
			Model model,
			RedirectAttributes state) {			
		Dorm dormtest = dormService.getByID(id);
		state = studentService.setDorm(studentToDorm, dormtest ,state);
		return "redirect:/dorms/"+ String.valueOf(dormtest.getId()) + "/get";
	}

	@RequestMapping(value="create", method=RequestMethod.GET)
	public String addDormByGet(
			@RequestParam("name") String name,
			RedirectAttributes state) {		
		state = dormService.addNewDormByGet(name, state);				
		Dorm dorm = dormService.getIdByName(name);
		String id = String.valueOf(dorm.getId());
		return "redirect:/dorms/"+id+"/get";
	}

	@RequestMapping(value="{id}/get", method=RequestMethod.GET)
	public String showStudentsInDorm(
			@PathVariable("id") Long id, 
			Model model,
			RedirectAttributes redirect,
			@ModelAttribute("newStudent") PreStudentDorm studentToDorm) {			
		Dorm dorm = dormService.findDorm(id, redirect);
		List<Student> studentList = studentService.getAllStudentsFromDorm(id);
		model.addAttribute("studentsList", studentList);
		model.addAttribute("students", studentService.getAllNullDormStudents());		
		model.addAttribute("dormRequested", dorm);
		return "dormStatus.jsp";
	}		
	
	@RequestMapping(value="{id}/remove", method=RequestMethod.GET)
	public String removeStudentByGet(
			@PathVariable("id")Long dormId,
			@RequestParam("student") Long studentId,
			RedirectAttributes redirect) {
		
		redirect = studentService.deleteFromDorm(dormId,studentId,redirect);
		
		
		return "redirect:/dorms/"+String.valueOf(dormId)+"/get";
	}


}
