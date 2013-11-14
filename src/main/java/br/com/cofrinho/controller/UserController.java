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

import br.com.cofrinho.model.User;
import br.com.cofrinho.service.UserService;
import br.com.cofrinho.utils.LoadDefaultMessage;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	private String redirectToListPage = "redirect:/user/list";
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addUserPage() {
		ModelAndView modelAndView = new ModelAndView("userAdd");
		modelAndView.addObject("user", new User());
		modelAndView.addObject("teams", userService.getTeams());
		modelAndView.addObject("userTypes", userService.getUserTypes());
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfUsers() {
		ModelAndView modelAndView = new ModelAndView("userList");				
		modelAndView.addObject("users", userService.getUsers());	
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{userId}", method=RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Integer userId) {
		ModelAndView modelAndView = new ModelAndView("userEdit");		
		modelAndView.addObject("user",userService.getUser(userId));
		modelAndView.addObject("teams", userService.getTeams());
		modelAndView.addObject("userTypes", userService.getUserTypes());
		return modelAndView;
	}	
		
	@RequestMapping(value="/delete/{userId}", method=RequestMethod.GET)
	public String deleteUser(@PathVariable Integer userId,  final RedirectAttributes redirectAttributes) throws IOException {
		LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();		
		userService.deleteUser(userId);
		redirectAttributes.addFlashAttribute("message",loadDefaultMessage.getMessage("register.deleted"));
		return redirectToListPage;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addingUser(@ModelAttribute User user,  final RedirectAttributes redirectAttributes) throws IOException {													
		LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();		
		try {
			userService.addUser(user);			
	        redirectAttributes.addFlashAttribute("message",loadDefaultMessage.getMessage("register.added"));				        	        
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message",loadDefaultMessage.getMessage("register.exists"));
			redirectToListPage = "redirect:/user/add";
		}		
		return redirectToListPage;
	}
	
	@RequestMapping(value="/edit/{userId}", method=RequestMethod.POST)
	public String edditingUser(@ModelAttribute User user, @PathVariable Integer userId, final RedirectAttributes redirectAttributes) throws IOException {					
		LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();
		userService.updateUser(user);				
		redirectAttributes.addFlashAttribute("message",loadDefaultMessage.getMessage("register.updated"));
		return redirectToListPage;
	}
	
	public ModelAndView returnModel(String message) throws IOException{
		ModelAndView modelAndView = new ModelAndView("userList");		
		LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();		
		modelAndView.addObject("message",loadDefaultMessage.getMessage(message));	
		modelAndView.addObject("users", userService.getUsers());
		return modelAndView;
	}
	
}
