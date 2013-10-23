package br.com.cofrinho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {
	@RequestMapping(value="/")
	public ModelAndView mainPage() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/index")
	public ModelAndView indexPage() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/manutencaoDeUsuario")
	public ModelAndView manutencaoDeUsuarioView() {
	    return new ModelAndView("manutencaoDeUsuario");
	}
	
	@RequestMapping(value="/home")
	public ModelAndView homeView() {
	    return new ModelAndView("homepage");
	}
	
	@RequestMapping(value="/homepage")
	public ModelAndView homePageView() {
	    return new ModelAndView("homepage");
	}
	
	@RequestMapping(value="/cadastroEquipe")
	public ModelAndView cadastroEquipeView() {
	    return new ModelAndView("cadastroEquipe");
	}
}
