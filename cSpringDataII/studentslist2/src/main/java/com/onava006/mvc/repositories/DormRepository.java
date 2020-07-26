package com.onava006.mvc.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onava006.mvc.Models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm,Long> {
	
	
	public Optional<Dorm> findByName(String name);

}
