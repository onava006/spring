package com.onava006.mvc.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onava006.mvc.Models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo,Long>{

	Optional<Dojo> findById(Long id);
	
	List<Dojo> findAll();
	
	Optional<Dojo> findByName(String name);
}
