package com.example.demotres;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {
	@RequestMapping("/asf")
	public String saludo() {
		return "hola";
	}
	
	@RequestMapping("/")
	public String salute(@RequestParam(value="name", required=false) String name, @RequestParam(value="lastname", required=false) String lastname) {
		String response;
		StringBuffer sb = new StringBuffer("<h1>Hola! ");	
		
		
		
		if(name == null) {
			sb.append("humano</h1>");
		} else if(lastname == null){
			sb.append(name + "</h1>");
			sb.append("<a href='/'>VOLVER</a>");
		}	else {
			sb.append(name);
			sb.append(" ");
			sb.append(lastname + "</h1>");
			sb.append("<a href='/'>VOLVER</a>");
		}
		
		response = sb.toString();			
		return response;
	}
}
