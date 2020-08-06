package com.onava006.mvc.Controllers;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onava006.mvc.Models.Dojo;
import com.onava006.mvc.Models.Ninja;
import com.onava006.mvc.Services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	@Autowired
	DojoService dojoServ;
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String prepareNewDojo(@ModelAttribute("newDojo") Dojo dojo) {
		return "createDojo.jsp";
	}

	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String createNewDojo(@Valid @ModelAttribute("newDojo") Dojo dojo, BindingResult result) {	
		if(result.hasErrors()) {
			return "redirect:/dojos/new"; 
		} 
		Dojo newDojo = dojoServ.createDojo(dojo);
		String id = String.valueOf(newDojo.getId());
				
		return "redirect:/dojos/"+id;
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String showDojo(@PathVariable("id") Long id, Model model, RedirectAttributes redirect) {
		
		Dojo dojoToView = dojoServ.finByid(id);		
		if(dojoToView == null) {
			redirect.addFlashAttribute("status", "el dojo que intenta encontrar no existe");
			return "redirect:/dojos/new";
		}
		List<Ninja> ninjaList = dojoToView.getNinjas();
		model.addAttribute("ninjas", ninjaList);
		model.addAttribute("dojo", dojoToView.getName());	
		
		return "viewDojo.jsp";
	}

}
