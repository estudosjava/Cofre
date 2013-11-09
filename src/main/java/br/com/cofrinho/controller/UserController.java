package br.com.cofrinho.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cofrinho.model.Team;
import br.com.cofrinho.model.User;
import br.com.cofrinho.service.UserService;
import br.com.cofrinho.utils.LoadDefaultMessage;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;						
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addUserPage() {
		ModelAndView modelAndView = new ModelAndView("userAdd");
		modelAndView.addObject("user", new User());
		modelAndView.addObject("teams", userService.getTeams());
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
		return modelAndView;
	}	
		
	@RequestMapping(value="/delete/{userId}", method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer userId) throws IOException {
		userService.deleteUser(userId);
		return returnModel("register.deleted");
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingUser(@ModelAttribute User user, Team team) throws IOException {											
		ModelAndView modelAndView = new ModelAndView("userList");
		LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();		
		try {
			userService.addUser(user);			
			modelAndView.addObject("users", userService.getUsers());					
			modelAndView.addObject("message",loadDefaultMessage.getMessage("register.added"));
			
		} catch (Exception e) {
			modelAndView = new ModelAndView("userAdd");			
			modelAndView.addObject("message",loadDefaultMessage.getMessage("register.exists"));
		}		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{userId}", method=RequestMethod.POST)
	public ModelAndView edditingUser(@ModelAttribute User user, @PathVariable Integer userId) throws IOException {					
		userService.updateUser(user);				
		return returnModel("register.updated");
	}
	
	public ModelAndView returnModel(String message) throws IOException{
		ModelAndView modelAndView = new ModelAndView("userList");		
		LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();		
		modelAndView.addObject("message",loadDefaultMessage.getMessage(message));	
		modelAndView.addObject("users", userService.getUsers());
		return modelAndView;
	}
	
}
