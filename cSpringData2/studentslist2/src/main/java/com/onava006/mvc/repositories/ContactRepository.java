package com.onava006.mvc.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.onava006.mvc.Models.ContactInfo;

@Repository
public interface ContactRepository extends CrudRepository<ContactInfo,Long> {
	
	Optional<ContactInfo> findByStudent_id(Long id);

}
