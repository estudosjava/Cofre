package br.com.cofrinho.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value="/addTypePenalty", method=RequestMethod.POST)
	public ModelAndView addingTypePenalty(@ModelAttribute TypePenalty typepenalty) throws IOException {
		ModelAndView modelAndView = new ModelAndView("typePenaltyAdd");
		typePenaltyService.addTypePenalty(typepenalty);
		modelAndView.addObject("message", Util.getMessage("register.added"));
		return modelAndView;
	}
	
	@RequestMapping(value="/listTypePenalty")
	public ModelAndView listOfTypePenalty() {
		ModelAndView modelAndView = new ModelAndView("typePenaltyList");
		List<TypePenalty> typepenaltys = typePenaltyService.getTypePenaltys();
		modelAndView.addObject("typepenaltys", typepenaltys);
		return modelAndView;
	}
}
