package com.example.ninja;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {
	@RequestMapping(value="/")
	public String ningaPlace() {
		return "index.jsp";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value= "/setgold", method=RequestMethod.POST)
	public String welcome(@RequestParam(value="place") String place,
			Model model, HttpSession session) {
		ArrayList<String> events;
		Ninja ninjon;

		if(session.getAttribute("gold") == null) {
			ninjon = new Ninja();
			session.setAttribute("gold", ninjon.getGold());
			session.setAttribute("events", events = new ArrayList<String>());			
		} else {
			
			ninjon = new Ninja((Integer)session.getAttribute("gold"));		
			ninjon.setRegistry((ArrayList<String>) session.getAttribute("events"));
		}

		ninjon.setGold(place);	

		session.setAttribute("gold", ninjon.getGold());
		session.setAttribute("events", ninjon.getRegistry());	
		model.addAttribute("events",ninjon.getRegistry());
		model.addAttribute("gold", ninjon.getGold());

		return "redirect:/";
	}
}
