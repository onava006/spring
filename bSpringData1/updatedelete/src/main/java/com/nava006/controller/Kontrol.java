package com.nava006.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nava006.Model.Books;
import com.nava006.services.BookServices;

@RestController
public class Kontrol {
	
	private final BookServices bookservice;	

	public Kontrol(BookServices bookservice) {
		this.bookservice = bookservice; 
	}	
	
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Books create(@RequestParam(value="title") String title, @RequestParam(value="description") String description, @RequestParam(value="language") String language, @RequestParam(value="pages") Integer pages) {
        Books book = new Books(title, description, language, pages);
        
        return bookservice.createBook(book);
    }    
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Books update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String description, @RequestParam(value="language") String language, @RequestParam(value="pages") Integer pages) {
        Books book = bookservice.updateBook(id, title, description, language, pages);
        return book;
    }
    
  
	
}
