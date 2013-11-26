package br.com.cofrinho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cofrinho.model.User;
import br.com.cofrinho.service.UserService;
import br.com.cofrinho.utils.LoadDefaultMessage;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/validaUsuario", method=RequestMethod.POST)
	public ModelAndView validateUser(@ModelAttribute User user){
		List<User> list = userService.checkUser(user); 
		if(userService.checkUser(user).size() > 0){
			ModelAndView modelAndView = new ModelAndView("homepage");
			modelAndView.addObject("userlog", list);
			return modelAndView;
		}else{
			ModelAndView modelAndView = new ModelAndView("login");
			LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();		
			modelAndView.addObject("message",loadDefaultMessage.getMessage("register.failed"));
			return modelAndView;
		}
	}	
}
