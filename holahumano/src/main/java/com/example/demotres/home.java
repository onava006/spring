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
		StringBuffer sb = new StringBuffer("<a href='/'>VOLVER</a>");		
		sb.append("<h1>Hola! ");
		
		if(name == null) {
			sb.append("humano");
		} else if(lastname == null){
			sb.append(name);
		}	else {
			sb.append(name);
			sb.append(" ");
			sb.append(lastname);
		}
		sb.append("</h1>");
		response = sb.toString();			
		return response;
	}
}
