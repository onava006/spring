package com.onava006.mvc.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onava006.mvc.Models.Ninja;
import com.onava006.mvc.Repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	NinjaRepository ninjaRepo;
	
	public Ninja createNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
		return ninja;
	}

}
