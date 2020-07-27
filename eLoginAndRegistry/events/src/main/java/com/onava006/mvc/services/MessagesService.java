package com.onava006.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onava006.mvc.repositories.MessagesRepository;

@Service
public class MessagesService {
	
	@Autowired
	MessagesRepository messageRepo;

}
