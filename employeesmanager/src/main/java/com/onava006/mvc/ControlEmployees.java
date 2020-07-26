package com.onava006.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControlEmployees {
	
	@Autowired
	EmployeeService serv;
	
	
	@RequestMapping("/")
	public String getWorkers(Model model) {
		List<String[]> employers = serv.getdudes(2L);
		List<String[]> employersAvello = serv.getdudes(9L);
		model.addAttribute("emp", employers);
		model.addAttribute("emp2", employersAvello);
		
		ArrayList<String> managerFromAemployee = serv.getmanager(10L);
		model.addAttribute("employeeWorkers", managerFromAemployee);
		
		
		return "index.jsp";
		
		
		
	}

}
