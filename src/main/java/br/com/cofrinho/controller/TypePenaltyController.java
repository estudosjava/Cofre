package br.com.cofrinho.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cofrinho.model.TypePenalty;
import br.com.cofrinho.service.TypePenaltyService;
import br.com.cofrinho.utils.LoadDefaultMessage;

@Controller
@RequestMapping(value="/typepenalty")
public class TypePenaltyController {

	@Autowired
	private TypePenaltyService typePenaltyService;
	private String redirectToListPage = "redirect:/typepenalty/listTypePenalty";
	
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
	public String deleteTypePenalty(@PathVariable Integer typePenaltyId,  final RedirectAttributes redirectAttributes) throws IOException {
		LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();
		typePenaltyService.deleteTypePenalty(typePenaltyId);
		redirectAttributes.addFlashAttribute("message",loadDefaultMessage.getMessage("register.deleted"));
		return redirectToListPage;
	}
	
	@RequestMapping(value="/addTypePenalty", method=RequestMethod.POST)
	public String addingTypePenalty(@ModelAttribute TypePenalty typepenalty,  final RedirectAttributes redirectAttributes) throws IOException {				
		LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();	
		typePenaltyService.addTypePenalty(typepenalty);	
		redirectAttributes.addFlashAttribute("message",loadDefaultMessage.getMessage("register.added"));
		return redirectToListPage;		
	}			
	
	@RequestMapping(value="/edit/{typePenaltyId}", method=RequestMethod.POST)
	public String edditingTypePenalty(@ModelAttribute TypePenalty typePenalty, @PathVariable Integer typePenaltyId,  final RedirectAttributes redirectAttributes) throws IOException {
		LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();
		typePenaltyService.updateTypePenalty(typePenalty);				
		redirectAttributes.addFlashAttribute("message",loadDefaultMessage.getMessage("register.updated"));
		return redirectToListPage;
	}
	
	@RequestMapping(value="/listTypePenalty")
	public ModelAndView listOfTypePenalty() {
		ModelAndView modelAndView = new ModelAndView("typePenaltyList");		
		modelAndView.addObject("typepenaltys", typePenaltyService.getTypePenaltys());
		return modelAndView;
	}
	
	public ModelAndView returnModel(String message) throws IOException{
		ModelAndView modelAndView = new ModelAndView("typePenaltyList");		
		LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();		
		modelAndView.addObject("message",loadDefaultMessage.getMessage(message));		
		modelAndView.addObject("typepenaltys", typePenaltyService.getTypePenaltys());
		return modelAndView;
	}
	
}
