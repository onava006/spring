package com.onava006.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onava006.mvc.models.Message;

@Repository
public interface MessagesRepository extends CrudRepository<Message,Long>{

}
