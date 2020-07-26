package com.example.demodos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	@RequestMapping("")
	public String helloDojo () {
		return "¡Hola Coding Dojo!";
	}
	@RequestMapping("/python")
	public String helloPython()	{
		return "¡Nunca vimos Python/Django!";
	}
	@RequestMapping("/java")
	public String helloJava() {
		return "¡Java/Spring es mejor!";
	}
	
	
}
