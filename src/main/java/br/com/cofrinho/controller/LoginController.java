package br.com.cofrinho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cofrinho.model.User;
import br.com.cofrinho.service.UserService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/validaUsuario", method=RequestMethod.POST)
	public String validateUser(@ModelAttribute User user){
		return (userService.checkUser(user)) ? "homepage" : "login";
	}	
}
