package com.onava006.mvc.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onava006.mvc.Models.Dojo;
import com.onava006.mvc.Repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	DojoRepository dojoRepo;
	
	public Dojo createDojo(Dojo dojo) {		
		dojoRepo.save(dojo);		
		return dojo;
	}

	public Dojo finByid(Long id) {
		Optional<Dojo> getDojo = dojoRepo.findById(id);
		if(getDojo.isPresent()) {
			return getDojo.get();
		} 
		return null;
	}
	
	public List<Dojo> getAllDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo findByName(String name) {
		Optional<Dojo> opt = dojoRepo.findByName(name);
		if(opt.isPresent()) {
			return opt.get();
		} 
		
		return null;
	}
}
