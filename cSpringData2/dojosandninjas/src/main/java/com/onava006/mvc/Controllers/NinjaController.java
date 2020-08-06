package com.onava006.mvc.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onava006.mvc.Models.Dojo;
import com.onava006.mvc.Models.Ninja;
import com.onava006.mvc.Services.DojoService;
import com.onava006.mvc.Services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	
	@Autowired
	NinjaService ninjaServ;
	@Autowired
	DojoService dojoServ;

	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String setNinja(@ModelAttribute("newNinja") Ninja ninja, Model model){
		
		
		List<Dojo> dojoList = dojoServ.getAllDojos();
		model.addAttribute("dojos", dojoList);
		
		return "createNinja.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("newNinja") Ninja ninja, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {			
			return "redirect:/ninjas/new";
		} else {
			ninja.setDojo(dojoServ.finByid(ninja.getDojoId()));
			
			ninjaServ.createNinja(ninja);
			
			
		}
		
		redirect.addFlashAttribute("status", "Se ha agregado un nuevo ninja al dojo");
		
		String id = String.valueOf(ninja.getId());
		return "redirect:/dojos/"+id;
	}
}
