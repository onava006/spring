package com.onava006.mvc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onava006.mvc.Models.ContactInfo;
import com.onava006.mvc.Models.Student;
import com.onava006.mvc.controllers.PreContact;
import com.onava006.mvc.repositories.ContactRepository;
import com.onava006.mvc.repositories.StudentRepository;

@Service
public class ContactService {


	@Autowired
	StudentRepository repoStudent;
	@Autowired
	ContactRepository repoContact;

	public RedirectAttributes addContactInfo(RedirectAttributes result, PreContact precontact, BindingResult status) {

		if(status.hasErrors()) {
			result.addAttribute("status", "no se pudo crear la cuenta");
		} else {

			String address = precontact.getAddress();
			String city = precontact.getCity();
			String state = precontact.getState();
			Student student; 

			Optional<ContactInfo> optContact = repoContact.findByStudent_id(precontact.getStudent_id());
			if(optContact.isPresent()) {
				result.addFlashAttribute("status", "no se ha podido crear el contacto porque ya existe");
			} else {
				Optional<Student> opt = repoStudent.findById(precontact.getStudent_id());
				if(opt.isPresent()) {
					student = opt.get(); 
					result.addFlashAttribute("status", "se ha creados un nuevo contacto");
					ContactInfo contactToAdd = new ContactInfo(address,city,state,student);				
					repoContact.save(contactToAdd);
				} 
			}
		}		

		return result;
	}

	public Iterable<ContactInfo> getAllContacts(){
		return repoContact.findAll();
	}
}