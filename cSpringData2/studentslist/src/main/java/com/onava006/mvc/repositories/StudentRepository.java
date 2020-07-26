package com.onava006.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.onava006.mvc.Models.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

}
