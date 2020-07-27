package com.onava006.learning.controllers;

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
import com.onava006.learning.models.Language;
import com.onava006.learning.services.ServLanguage;

@Controller
@RequestMapping(value="/")
public class LanguageControl {
	
	@Autowired
	ServLanguage servicio;

	
	@RequestMapping(value= "language")
	public String getAllBook(Model model, @ModelAttribute("newlang") Language language) {
		List<Language> languageList = servicio.findAll();
		model.addAttribute("languages", languageList); 
		return "index.jsp";		
	}
	
	@RequestMapping(value="language/{id}")
	public String showLanguage(@PathVariable("id") Long id, Model model) {
		Language lang = servicio.getLangByID(id);
		model.addAttribute("content", lang);
		return "info.jsp";
	}	
	
	@RequestMapping(value="/language/{id}/delete", method=RequestMethod.GET)
	public String destroy(@PathVariable("id") 
			Long id, 
			RedirectAttributes deleteNotif) 
	{	        
		deleteNotif = servicio.deleteBook(id, deleteNotif);
		return "redirect:/language";
	}	
	
	@RequestMapping(value="/language/{id}/edit", method= RequestMethod.GET)
	public String modify(@PathVariable("id")
			Long id, Model model) {
		Language lang = servicio.getLangByID(id);
		model.addAttribute("content", lang);
		return "update.jsp";		
	}
	
	@RequestMapping(value="language/{id}", method= RequestMethod.PUT)
	public String showUpdate(@Valid @ModelAttribute("content") 
		Language language, 
		BindingResult result) {
		if (result.hasErrors()) {
            return "update.jsp";
        } else {
            servicio.updateLang(language);
            return "redirect:/language";
        }
	}
	
	@RequestMapping(value="language/create", method=RequestMethod.POST)
	public String createNew(@Valid @ModelAttribute("newlang") 
			Language lang, 
			BindingResult result, 
			RedirectAttributes redirect, Model model)
	{				
		servicio.addNewLanguage(lang, result, redirect, model);
		return "redirect:/language";
	}

}







