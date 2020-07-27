package com.onava006.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onava006.mvc.repositories.UsersRepository;

@Service
public class UsersService {
	@Autowired
	UsersRepository userRepo;

}
