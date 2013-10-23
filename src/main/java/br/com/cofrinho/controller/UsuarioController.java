package br.com.cofrinho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cofrinho.UsuarioDao;
import br.com.cofrinho.model.Usuario;
import br.com.cofrinho.service.UsuarioService;


@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;		
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addUsuarioPage() {
		ModelAndView modelAndView = new ModelAndView("cadastroDeUsuario");
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingUsuario(@ModelAttribute Usuario usuario) {
		
		ModelAndView modelAndView = new ModelAndView("manutencaoDeUsuario");
		usuarioService.addUsuario(usuario);
		
		String message = "Usuário inserido com sucesso!";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfUsuarios() {
		ModelAndView modelAndView = new ModelAndView("listaDeUsuario");
		
		List<Usuario> usuarios = usuarioService.getUsuarios();
		modelAndView.addObject("usuarios", usuarios);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{codUsuario}", method=RequestMethod.GET)
	public ModelAndView editUsuarioPage(@PathVariable Integer codUsuario) {
		ModelAndView modelAndView = new ModelAndView("edicaoDeUsuario");
		Usuario usuario = usuarioService.getUsuario(codUsuario);
		modelAndView.addObject("usuario",usuario);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{codUsuario}", method=RequestMethod.POST)
	public ModelAndView edditingUsuario(@ModelAttribute Usuario usuario, @PathVariable Integer codUsuario) {
		
		ModelAndView modelAndView = new ModelAndView("manutencaoDeUsuario");
		
		usuarioService.updateUsuario(usuario);
		
		String message = "Usuário editado com sucesso!";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{codUsuario}", method=RequestMethod.GET)
	public ModelAndView deleteUsuario(@PathVariable Integer codUsuario) {
		ModelAndView modelAndView = new ModelAndView("manutencaoDeUsuario");
		usuarioService.deleteUsuario(codUsuario);
		String message = "Usuário apagado com sucesso!";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	
	
}
