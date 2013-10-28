package br.com.cofrinho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cofrinho.dao.UserDAO;
import br.com.cofrinho.model.User;

@Controller
public class LoginController {
		
	@RequestMapping("/validaUsuario")
	public String valida(User user) {
		String telaRedirect = "homepage";
		UserDAO dao = new UserDAO();
		boolean cadastrado = dao.checkUser(user);
		
		if (!cadastrado) {
			telaRedirect = "login";
		} else {
			telaRedirect = "homepage";
		}
		
		return telaRedirect;
	}

}
