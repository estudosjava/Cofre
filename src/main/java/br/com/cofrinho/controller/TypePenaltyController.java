package br.com.cofrinho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cofrinho.model.TypePenalty;
import br.com.cofrinho.service.TypePenaltyService;

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
	
	@RequestMapping(value="/addTypePenalty", method=RequestMethod.POST)
	public ModelAndView addingTypePenalty(@ModelAttribute TypePenalty typepenalty) {
		
		ModelAndView modelAndView = new ModelAndView("typePenaltyMaintenance");
		typePenaltyService.addTypePenalty(typepenalty);
		
		String message = "Tipo de Multa inserida com sucesso!";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
}
