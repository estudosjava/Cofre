package br.com.cofrinho.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cofrinho.model.User;
import br.com.cofrinho.service.UserService;
import br.com.cofrinho.utils.Util;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;			
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addUserPage() {
		ModelAndView modelAndView = new ModelAndView("userAdd");
		modelAndView.addObject("user", new User());
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
	public ModelAndView addingUser(@ModelAttribute User user) throws IOException {											
		userService.addUser(user);		
		return returnModel("register.added");
	}
	
	@RequestMapping(value="/edit/{userId}", method=RequestMethod.POST)
	public ModelAndView edditingUser(@ModelAttribute User user, @PathVariable Integer userId) throws IOException {		
		userService.updateUser(user);				
		return returnModel("register.updated");
	}
	
	public ModelAndView returnModel(String message) throws IOException{
		ModelAndView modelAndView = new ModelAndView("userList");		
		modelAndView.addObject("message", Util.getMessage(message));	
		modelAndView.addObject("users", userService.getUsers());
		return modelAndView;
	}
	
}
