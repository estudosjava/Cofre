package br.com.cofrinho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cofrinho.model.User;
import br.com.cofrinho.service.UserService;


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
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingUser(@ModelAttribute User user) {
		
		ModelAndView modelAndView = new ModelAndView("userMaintenance");
		userService.addUser(user);
		
		String message = "Usuário inserido com sucesso!";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfUsers() {
		ModelAndView modelAndView = new ModelAndView("userList");
		
		List<User> users = userService.getUsers();
		modelAndView.addObject("users", users);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{userId}", method=RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Integer userId) {
		ModelAndView modelAndView = new ModelAndView("userEdit");
		
		User user = userService.getUser(userId);
		modelAndView.addObject("user",user);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{userId}", method=RequestMethod.POST)
	public ModelAndView edditingUser(@ModelAttribute User user, @PathVariable Integer userId) {
		
		ModelAndView modelAndView = new ModelAndView("userMaintenance");
		
		userService.updateUser(user);
		
		String message = "Usuário editado com sucesso!";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{userId}", method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer userId) {
		ModelAndView modelAndView = new ModelAndView("userMaintenance");
		
		userService.deleteUser(userId);
		
		String message = "Usuário apagado com sucesso!";		
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}	
	
}
