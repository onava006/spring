package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.CountStatus;

@Controller
public class Home {


	@RequestMapping("your_server")	
	public String setSiteStatus(HttpSession session) {

		if(session.getAttribute("conteoStatus") == null) {
			CountStatus counting = new CountStatus();
			counting.increaseCounter();
			Integer value = counting.getCount();
			session.setAttribute("conteoStatus", value);			
		} else {
			Integer numberOfTimesOpennedSite = (Integer)session.getAttribute("conteoStatus");
			CountStatus counting = new CountStatus(numberOfTimesOpennedSite);
			counting.increaseCounter();
			Integer value = counting.getCount();
			session.setAttribute("conteoStatus", value);	
		}
		return "home.jsp";

	}
	
	@RequestMapping("your_server/counter")
	public String getSiteStatus(HttpSession session, Model model,  @RequestParam(name="reset",required = false) String reset) {
		Integer numero = 0;	

		
		if(session.getAttribute("conteoStatus") == null) {
			session.setAttribute("conteoStatus", numero);
		} else if (reset != null){		
			session.setAttribute("conteoStatus", numero);
			reset = null;
		} else {
			numero = (Integer)session.getAttribute("conteoStatus");
		}
		model.addAttribute("teston", reset);
		model.addAttribute("conteo", String.valueOf(numero));

		return "counting.jsp";
	}
	
	@RequestMapping("your_server/twice")	
	public String setSitetwice(HttpSession session) {

		if(session.getAttribute("conteoStatus") == null) {
			CountStatus counting = new CountStatus();
			counting.increaseCounter(2);
			Integer value = counting.getCount();
			session.setAttribute("conteoStatus", value);			
		} else {
			Integer numberOfTimesOpennedSite = (Integer)session.getAttribute("conteoStatus");
			CountStatus counting = new CountStatus(numberOfTimesOpennedSite);
			counting.increaseCounter(2);
			Integer value = counting.getCount();
			session.setAttribute("conteoStatus", value);	
		}
		return "home.jsp";

	}



}
