package com.onava006.mvc.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onava006.mvc.Models.Dorm;
import com.onava006.mvc.repositories.DormRepository;
import com.onava006.mvc.repositories.StudentRepository;

@Service
public class DormService {


	@Autowired
	DormRepository repoDorm;

	@Autowired
	StudentRepository repoStudent;	

	public RedirectAttributes addNewDormByGet(String name,
			RedirectAttributes state) {

		Optional<Dorm> opt = repoDorm.findByName(name);	
		if(opt.isPresent()) {
			state.addFlashAttribute("status", "ya existe un dormitorio con ese nombre");	
		} else {
			state.addFlashAttribute("status", "se ha creado un nuevo dormitorio, agregado en la barrra de direcciones");
			Dorm dorm = new Dorm(name);		
			repoDorm.save(dorm);
		}	
		return state;		
	}

	public Dorm getIdByName(String name) {
		Optional<Dorm> opt = repoDorm.findByName(name);	
		return opt.get();
	}
	
	
	public RedirectAttributes AddNewDorm(@Valid Dorm dorm, 
			BindingResult result,
			RedirectAttributes redirect)  {
		if(result.hasErrors()) {
			redirect.addFlashAttribute("status", "No se ha podido crear el nuevo dormitorio");
		} else {
			redirect.addFlashAttribute("status", "Se ha creado un nuevo dormitorio, esperando por los estudiantes");
			repoDorm.save(dorm);
		} 
		return redirect;

	}

	public Dorm getByID(Long id) {
		Optional<Dorm> opt = repoDorm.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public Dorm findDorm(Long id, RedirectAttributes redirect) {
		Optional<Dorm> opt= repoDorm.findById(id);
		if (opt.isPresent()) {
			redirect.addFlashAttribute("status","Existe el dormitorio");
			return opt.get();
		} else {
			redirect.addFlashAttribute("status","No existe el dormitorio seleccionado");
		} return null;
	}

}
