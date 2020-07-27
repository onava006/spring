package com.nava006.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nava006.Model.Books;
import com.nava006.repositories.Repositories;

@Service
public class BookServices {
	private final Repositories repo; 

	public BookServices(Repositories repo) {
		this.repo = repo;
	}

	public List<Books> showAllBooks(){
		return repo.findAll();
	}

	public Books findByIDBook(Long ID) {
		Optional<Books> opt = repo.findById(ID);
		if(opt.isPresent()) {
			return opt.get();
		}else{
			return null;
		}			
	}
	
	public Books createBook(Books b) {
        return repo.save(b);
    }

	public Books updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Optional<Books> opt = repo.findById(id);
		if (opt.isPresent()) {
			Books boc = new Books(id, title, desc, lang, numOfPages);	
			return repo.save(boc);
		} else 
		{
			return null;
		}
	}
	public void updateBook(@Valid Books book) {
		repo.save(book);
		
	}

	public RedirectAttributes deleteBook(Long id, RedirectAttributes deleteNotif) {
		Optional<Books> book = repo.findById(id);
		if(book.isPresent()) {
			Books toDelete = book.get();
			deleteNotif.addFlashAttribute("del", "Se borró " + toDelete.getTitle());
			repo.deleteById(id);
		} else {
			String notif =  "No se encontró el libro que intentó borrar";
			deleteNotif.addFlashAttribute("del", notif);
		}
			
		
		return deleteNotif;		
		
	}

	



}
