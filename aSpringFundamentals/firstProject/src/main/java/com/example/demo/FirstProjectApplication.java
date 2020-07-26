package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hellou() {
		return "Hello client, how are you doing?";
		
	}
	@RequestMapping("/Random")
	public String hellowSpring(){
		return "Spring boot is great!, so easy to respond with strings";
	}

}
