package com.nava006.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nava006.Model.Books;
import com.nava006.services.BookServices;

@Controller
public class ControlBooks {

	@Autowired
	BookServices bookservice;	

	public ControlBooks(BookServices bookservice) {
		this.bookservice = bookservice; 
	}
	@RequestMapping("/books")
	public String getMain(Model model) {
		List<Books> bookcatalog = bookservice.showAllBooks();
		model.addAttribute("bookcatalog",bookcatalog);
		return "index.jsp";	
	}

	@RequestMapping(value="/api/books/{id}", method=RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		Books book = bookservice.findByIDBook(id);
		model.addAttribute("book", book);
		return "show.jsp";
	}
	@RequestMapping(value="/api/books/delete/{id}", method=RequestMethod.GET)
	public String destroy(@PathVariable("id") Long id, RedirectAttributes deleteNotif) {	        
		deleteNotif = bookservice.deleteBook(id, deleteNotif);
		return "redirect:/";
	}
	
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroyByJsp(@PathVariable("id") Long id, RedirectAttributes deleteNotif) {
    	deleteNotif = bookservice.deleteBook(id, deleteNotif);
        return "redirect:/books";
    }
    
	@RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Books book) {
        return "new.jsp";
    }
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Books book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookservice.createBook(book);
            return "redirect:/books";
        }
    }
	@RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Books book = bookservice.findByIDBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Books book, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            bookservice.updateBook(book);
            return "redirect:/books";
        }
    }


}











