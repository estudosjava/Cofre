package br.com.cofrinho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cofrinho.UsuarioDao;
import br.com.cofrinho.model.Usuario;

@Controller
public class LoginController {
		
	@RequestMapping("/validaUsuario")
	public String valida(Usuario usuario) {
		String telaRedirect = "homepage";
		UsuarioDao dao = new UsuarioDao();
		boolean cadastrado = dao.buscaUsuario(usuario);
		
		if (!cadastrado) {
			telaRedirect = "login";
		} else {
			telaRedirect = "homepage";
		}
		
		return telaRedirect;
	}

}