package com.example.code;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onava006.model.CodeProcessor;

@Controller
public class Home {

	@RequestMapping(value="/")
	public String checkPassword(){
		return "index.jsp";
	}

	@RequestMapping(value="/code", method=RequestMethod.POST)
	public String okayCode(RedirectAttributes redirectAttributes, 
			@RequestParam(value="code") String trying, HttpSession session) {

		CodeProcessor samurai = new CodeProcessor(trying);
		if(samurai.getStatusPass()) {
			session.setAttribute("status", "okay");
			session.setAttribute("try", trying);
			return "samuraiCode.jsp";		
		} else {
			redirectAttributes.addFlashAttribute("error", samurai.getErrorcode());
			session.setAttribute("status", "notkay");
			return "redirect:/";
		}
	}

	@RequestMapping(value="/code", method=RequestMethod.GET)
	public String checkWay(RedirectAttributes redirectAttributes, HttpSession session) {
		redirectAttributes.addFlashAttribute("error", CodeProcessor.getJumpErrorCode());
		return "redirect:/";		
	}
}
