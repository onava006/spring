package com.onava006.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onava006.mvc.models.User;

@Repository
public interface UsersRepository extends CrudRepository<User,Long>{

}
