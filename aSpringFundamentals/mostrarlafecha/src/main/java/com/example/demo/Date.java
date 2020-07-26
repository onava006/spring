package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Date {

	@RequestMapping("/Date")
	public String getDate(Model model) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE, 'The ' dd 'of' MMMM, yyyy" );  
		LocalDateTime now = LocalDateTime.now();  
		String today = dtf.format(now);  
		model.addAttribute("today",today);
		return "today.jsp";
	}
	
	@RequestMapping("/Time")

	public String setDate(Model model) {			
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm:ss a");  
		LocalDateTime now = LocalDateTime.now();  
		String hour = dtf.format(now);  
		model.addAttribute("now",hour);

		return "time.jsp";	
	}

}
