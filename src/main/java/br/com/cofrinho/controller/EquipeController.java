package br.com.cofrinho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cofrinho.model.Equipe;
import br.com.cofrinho.service.EquipeService;


@Controller
@RequestMapping(value="/equipe")
public class EquipeController {
	
	@Autowired
	private EquipeService equipeService;	
	
	@RequestMapping(value="/cadastrarEquipe", method=RequestMethod.GET)
	public ModelAndView addEquipePage() {
		ModelAndView modelAndView = new ModelAndView("cadastroEquipe");
		modelAndView.addObject("equipe", new Equipe());
		return modelAndView;
	}
	
	@RequestMapping(value="/cadastrarEquipe", method=RequestMethod.POST)
	public ModelAndView addingEquipe(@ModelAttribute Equipe equipe) {
		
		ModelAndView modelAndView = new ModelAndView("manutencaoEquipe");
		equipeService.addEquipe(equipe);
		
		String message = "Equipe inserida com sucesso!";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfEquipes() {
		ModelAndView modelAndView = new ModelAndView("listaEquipe");
		
		List<Equipe> equipes = equipeService.getEquipes();
		modelAndView.addObject("equipes", equipes);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{codEquipe}", method=RequestMethod.GET)
	public ModelAndView editEquipePage(@PathVariable Integer codEquipe) {
		ModelAndView modelAndView = new ModelAndView("edicaoEquipe");
		Equipe equipe = equipeService.getEquipe(codEquipe);
		modelAndView.addObject("equipe",equipe);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{codEquipe}", method=RequestMethod.POST)
	public ModelAndView edditingEquipe(@ModelAttribute Equipe equipe, @PathVariable Integer codEquipe) {
		
		ModelAndView modelAndView = new ModelAndView("manutencaoEquipe");
		
		equipeService.updateEquipe(equipe);
		
		String message = "Equipe editada com sucesso!";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{codEquipe}", method=RequestMethod.GET)
	public ModelAndView deleteEquipe(@PathVariable Integer codEquipe) {
		ModelAndView modelAndView = new ModelAndView("manutencaoEquipe");
		equipeService.deleteEquipe(codEquipe);
		String message = "Equipe apagada com sucesso!";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
}
