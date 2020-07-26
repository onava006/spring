package com.onava006.mvc.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onava006.mvc.models.User;
import com.onava006.mvc.services.UserService;

@Controller
public class Users {

	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String redirectToLogin(){
		return "redirect:/login";
		
	}

	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	@RequestMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}

	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {


		if(result.hasErrors()) {
			return "redirect:/registration";
		} else {
			userService.registerUser(user);
			session.setAttribute("id", user.getId());
		}	 
		return "redirect:/home";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirect) {
		User user;
		if(userService.authenticateUser(email, password)) {
			user = userService.findByEmail(email);
			session.setAttribute("id", user.getId());
			return "redirect:/home";
		} else {
			redirect.addFlashAttribute("status", "No se ha podido autenticar el usuario");			
		}
		
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public String home(HttpSession session, Model model, RedirectAttributes redirect) {
		Long userSessionId;
		try {
			userSessionId = (Long)session.getAttribute("id");
			User user = (User)userService.findUserById(userSessionId);
			model.addAttribute("user", user);	
		}		
		catch(Exception e) {
			redirect.addFlashAttribute("status", "ha ocurrido un error/ruta errónea. Por favor inicie sesión");
			return "redirect:/login";
		} 
		
		return "homePage.jsp";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		request.getSession(false)
		// redireccionar a la página de inicio de sesión.
		return "loginPage.jsp";
	}
}











