package com.nava006.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.nava006.Model.Books;

public interface Repositories extends CrudRepository<Books,Long>{
	 List<Books> findAll();
	    //Este método encuentra un libro por su descripción
	    List<Books> findByDescriptionContaining(String search);
	    //Este método cuenta cuántos libros contiene cierta cadena en el título
	    Long countByTitleContaining(String search);
	    //Este método borra un libro que empieza con un título específico
	    Long deleteByTitleStartingWith(String search);	    
	    void deleteById(Long ID);
	  
}

