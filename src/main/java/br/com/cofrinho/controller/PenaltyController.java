package br.com.cofrinho.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cofrinho.model.Penalty;
import br.com.cofrinho.service.PenaltyService;
import br.com.cofrinho.utils.LoadDefaultMessage;

@Controller
@RequestMapping(value="/penalty")
public class PenaltyController{

	@Autowired
	private PenaltyService penaltyService;

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addUserPage() {
		ModelAndView modelAndView = new ModelAndView("penaltyAdd");
		modelAndView.addObject("penalty", new Penalty());
		modelAndView.addObject("users", penaltyService.getUsers());		
		modelAndView.addObject("typePenaltys", penaltyService.getTypePenaltys());
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{penaltyId}", method=RequestMethod.GET)
	public ModelAndView editPenaltyPage(@PathVariable Integer penaltyId) {
		ModelAndView modelAndView = new ModelAndView("penaltyEdit");		
		modelAndView.addObject("penalty",penaltyService.getPenalty(penaltyId));	
		modelAndView.addObject("users", penaltyService.getUsers());		
		modelAndView.addObject("typePenaltys", penaltyService.getTypePenaltys());
		return modelAndView;
	}
	
	@RequestMapping(value="/listPenalty")
	public ModelAndView listOfPenalty(){
		ModelAndView modelAndView = new ModelAndView("penaltyList");
		modelAndView.addObject("penaltys", penaltyService.getPenaltys());
		return modelAndView;
	}

	@RequestMapping(value="/delete/{penaltyId}", method=RequestMethod.GET)
	public ModelAndView deletePenalty(@PathVariable Integer penaltyId) throws IOException {
		penaltyService.deletePenalty(penaltyId);
		return returnModel("register.deleted");
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingPenalty(@ModelAttribute Penalty penalty) throws IOException {											
		ModelAndView modelAndView = new ModelAndView("penaltyList");
		LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();		
		try {
			penaltyService.addPenalty(penalty);			
			modelAndView.addObject("penaltys", penaltyService.getPenaltys());					
			modelAndView.addObject("message",loadDefaultMessage.getMessage("register.added"));			
		} catch (Exception e) {
			modelAndView = new ModelAndView("penaltyAdd");			
			modelAndView.addObject("message",loadDefaultMessage.getMessage("register.exists"));
		}		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{penaltyId}", method=RequestMethod.POST)
	public ModelAndView edditingPenalty(@ModelAttribute Penalty penalty, @PathVariable Integer penaltyId) throws IOException {					
		penaltyService.updatePenalty(penalty);				
		return returnModel("register.updated");
	}
	
	public ModelAndView returnModel(String message) throws IOException{
		ModelAndView modelAndView = new ModelAndView("penaltyList");		
		LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();		
		modelAndView.addObject("message",loadDefaultMessage.getMessage(message));	
		modelAndView.addObject("penaltys", penaltyService.getPenaltys());
		return modelAndView;
	}
}
