package br.com.cofrinho.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cofrinho.service.PenaltyService;
import br.com.cofrinho.utils.Util;

@Controller
@RequestMapping(value="/penalty")
public class PenaltyController{

	@Autowired
	private PenaltyService penaltyService;

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

	public ModelAndView returnModel(String message) throws IOException{
		ModelAndView modelAndView = new ModelAndView("penaltyList");
		modelAndView.addObject("message", Util.getMessage(message));
		modelAndView.addObject("penaltys", penaltyService.getPenaltys());
		return modelAndView;
	}
}
