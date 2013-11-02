package br.com.cofrinho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cofrinho.service.PenaltyService;

@Controller
@RequestMapping(value="/penalty")
public class PenaltyController {

	@Autowired
	private PenaltyService penaltyService;

	@RequestMapping(value = "/listPenalty")
	public ModelAndView listOfPenalty() {
		ModelAndView modelAndView = new ModelAndView("penaltyList");
		modelAndView.addObject("penaltys", penaltyService.getPenaltys());
		return modelAndView;
	}

}
