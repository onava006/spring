package com.onava006.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.onava006.mvc.Models.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

	Iterable<Student> findByDorm_idIsNull();
	
	Iterable<Student> findByDorm_id(Long id);
	
}
