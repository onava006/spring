package com.onava006.learning.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onava006.learning.models.Language;

@Repository
public interface RepoLanguages extends CrudRepository<Language,Long>{

	List<Language> findAll();

	void deleteById(Long ID);

}
