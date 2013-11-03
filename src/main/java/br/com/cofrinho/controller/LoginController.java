package br.com.cofrinho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cofrinho.model.User;
import br.com.cofrinho.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/validaUsuario")
	public String valida(@ModelAttribute User user) {
		String telaRedirect;		
		
		boolean cadastrado = userService.checkUser(user);
		
		if (!cadastrado) {
			telaRedirect = "login";
		} else {
			telaRedirect = "homepage";
		}
		
		return telaRedirect;
	}

}
