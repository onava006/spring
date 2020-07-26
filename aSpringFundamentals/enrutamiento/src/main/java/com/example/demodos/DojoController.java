package com.example.demodos;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class DojoController {
	@RequestMapping("/{dojoLocation}")
	public String dojosReaction(@PathVariable("dojoLocation") String location) {
		String reaction = "";

		switch(location) {
		
		case "dojo": reaction = "¡El Dojo es increíble!";
		break;
		case "burbank-dojo": reaction = "El Dojo Burbank está localizado al sur de California";
		break;
		case "san-jose": reaction = "El Dojo SJ es el cuartel general";
		break; 
		default: reaction = "aún no sé si esto está bien hecho";
		}

		return reaction;	
	}
}

//"http://localhost:8080/dojo" 
//http://localhost:8080/burbank-dojo
//"http://localhost:8080/san-jose"

