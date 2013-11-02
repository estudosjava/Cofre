package br.com.cofrinho.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cofrinho.model.TypePenalty;
import br.com.cofrinho.service.TypePenaltyService;
import br.com.cofrinho.utils.Util;

@Controller
@RequestMapping(value="/typepenalty")
public class TypePenaltyController {

	@Autowired
	private TypePenaltyService typePenaltyService;
	
	@RequestMapping(value="/addTypePenalty", method=RequestMethod.GET)
	public ModelAndView addTypePenaltyPage() {
		ModelAndView modelAndView = new ModelAndView("typePenaltyAdd");
		modelAndView.addObject("typepenalty", new TypePenalty());
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{typePenaltyId}", method=RequestMethod.GET)
	public ModelAndView editTypePenaltyPage(@PathVariable Integer typePenaltyId) {
		ModelAndView modelAndView = new ModelAndView("typePenaltyEdit");		
		modelAndView.addObject("typepenalty",typePenaltyService.getTypePenalty(typePenaltyId));		
		return modelAndView;
	}
		
	@RequestMapping(value="/delete/{typePenaltyId}", method=RequestMethod.GET)
	public ModelAndView deleteTypePenalty(@PathVariable Integer typePenaltyId) throws IOException {
		typePenaltyService.deleteTypePenalty(typePenaltyId);
		return returnModel("register.deleted");
	}
	
	@RequestMapping(value="/addTypePenalty", method=RequestMethod.POST)
	public ModelAndView addingTypePenalty(@ModelAttribute TypePenalty typepenalty) throws IOException {		
		typePenaltyService.addTypePenalty(typepenalty);			
		return returnModel("register.added");
	}			
	
	@RequestMapping(value="/edit/{typePenaltyId}", method=RequestMethod.POST)
	public ModelAndView edditingTypePenalty(@ModelAttribute TypePenalty typePenalty, @PathVariable Integer typePenaltyId) throws IOException {		
		typePenaltyService.updateTypePenalty(typePenalty);				
		return returnModel("register.updated");
	}
	
	@RequestMapping(value="/listTypePenalty")
	public ModelAndView listOfTypePenalty() {
		ModelAndView modelAndView = new ModelAndView("typePenaltyList");		
		modelAndView.addObject("typepenaltys", typePenaltyService.getTypePenaltys());
		return modelAndView;
	}
	
	public ModelAndView returnModel(String message) throws IOException{
		ModelAndView modelAndView = new ModelAndView("typePenaltyList");		
		modelAndView.addObject("message", Util.getMessage(message));	
		modelAndView.addObject("typepenaltys", typePenaltyService.getTypePenaltys());
		return modelAndView;
	}
	
}
