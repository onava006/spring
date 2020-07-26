package com.example.language;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Processor {
	@RequestMapping(value="/")
	public String getForm() {
		return "index.jsp";
	}


	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String dispatchForm(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "dojolocation") String location,
			@RequestParam(value = "favoritelanguage") String language, 
			@RequestParam(value = "comment", required = false ) String comment,
			Model model)
	{		  
		Formularium formulario = new Formularium(name, location,language, comment);

		model.addAttribute("name", formulario.getName());
		model.addAttribute("location", formulario.getLocation());
		model.addAttribute("language", formulario.getLanguage());
		model.addAttribute("comment", formulario.getComment());
		
		return "form.jsp";

	}
	@RequestMapping(value="/result", method=RequestMethod.GET)
	public String dispatchForm()
	{
		return "redirect:/";
	}
}
