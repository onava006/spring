package com.onava006.learning.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.onava006.learning.models.Language;
import com.onava006.learning.repositories.RepoLanguages;

@Service
public class ServLanguage{
	
	@Autowired
	RepoLanguages repo;
	
	public ServLanguage(RepoLanguages repo) {
		this.repo = repo;
	}
	
	public void addNewLanguage(
			Language lang, 
			BindingResult result, 
			RedirectAttributes redirect, 
			Model model) {
			
		if(result.hasErrors()) {
			redirect.addFlashAttribute("status", "No se pudo almacenar la información");
			model.addAttribute("errors", result.getAllErrors());		
		} else {
			repo.save(lang);
			redirect.addFlashAttribute("status", "Se ha almacenado un nuevo lenguaje");			
		}				
	}
	
	public List<Language> findAll() {
		return repo.findAll();
	}
	
	public Language getLangByID(Long id) {
		Optional<Language> opt= repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}		
	}
	
	public RedirectAttributes deleteBook(
			Long id, 
			RedirectAttributes deleteNotif) {
		Optional<Language> book = repo.findById(id);
		if(book.isPresent()) {
			Language toDelete = book.get();
			deleteNotif.addFlashAttribute("status", "Se borró " + toDelete.getName());
			repo.deleteById(id);
		} else {
			String notif =  "No se encontró lo que intentó borrar";
			deleteNotif.addFlashAttribute("status", notif);
		}			
		return deleteNotif;		
		
	}

	public void updateLang(@Valid Language language) {
		repo.save(language);		
	}

}
