package com.onava006.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	@RequestMapping(value="/")
	public String mainPage() {
		return "home.jsp";
	}
}
