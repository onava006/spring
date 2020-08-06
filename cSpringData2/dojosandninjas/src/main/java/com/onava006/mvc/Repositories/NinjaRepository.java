package com.onava006.mvc.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onava006.mvc.Models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja,Long> {

}
