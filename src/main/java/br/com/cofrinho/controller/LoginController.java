package br.com.cofrinho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cofrinho.dao.UsuarioDAOImpl;
import br.com.cofrinho.model.Usuario;

@Controller
public class LoginController {
		
	@RequestMapping("/validaUsuario")
	public String valida(Usuario usuario) {
		String telaRedirect = "homepage";
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		boolean cadastrado = dao.validaUsuario(usuario);
		
		if (!cadastrado) {
			telaRedirect = "login";
		} else {
			telaRedirect = "homepage";
		}
		
		return telaRedirect;
	}

}
