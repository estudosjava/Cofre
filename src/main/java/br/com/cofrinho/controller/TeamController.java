package br.com.cofrinho.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cofrinho.model.Team;
import br.com.cofrinho.service.TeamService;
import br.com.cofrinho.utils.LoadDefaultMessage;


@Controller
@RequestMapping(value="/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;	
	
	@RequestMapping(value="/addTeam", method=RequestMethod.GET)
	public ModelAndView addTeamPage() {
		ModelAndView modelAndView = new ModelAndView("teamAdd");
		modelAndView.addObject("team", new Team());
		return modelAndView;
	}
	
	@RequestMapping(value="/listTeam")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("teamList");	
		modelAndView.addObject("teams", getListTeams());
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{teamId}", method=RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer teamId) {
		ModelAndView modelAndView = new ModelAndView("teamEdit");
		Team team = teamService.getTeam(teamId);
		modelAndView.addObject("team",team);
		return modelAndView;
	}	
	
	@RequestMapping(value="/addTeam", method=RequestMethod.POST)
	public ModelAndView addingTeam(@ModelAttribute Team team) throws IOException {		
		ModelAndView modelAndView = new ModelAndView("teamList");
		LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();				
		try {
			teamService.addTeam(team);						
			modelAndView.addObject("teams", getListTeams());
			modelAndView.addObject("message",loadDefaultMessage.getMessage("register.added"));					
		} catch (Exception e) {
			modelAndView = new ModelAndView("teamAdd");
			modelAndView.addObject("message",loadDefaultMessage.getMessage("register.exists"));
		}
		return modelAndView;
	}
		
	@RequestMapping(value="/edit/{teamId}", method=RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute Team team, @PathVariable Integer teamId) throws IOException {				
		teamService.updateTeam(team);		
		return returnModel("register.updated");
	}
	
	@RequestMapping(value="/delete/{teamId}", method=RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer teamId) throws IOException {		
		teamService.deleteTeam(teamId);
		return returnModel("register.deleted");
	}
	
	public List<Team> getListTeams(){
		List<Team> teams = teamService.getTeams();
		return teams;
	}
	
	public ModelAndView returnModel(String message) throws IOException{
		ModelAndView modelAndView = new ModelAndView("teamList");		
		LoadDefaultMessage loadDefaultMessage = new LoadDefaultMessage();		
		modelAndView.addObject("message",loadDefaultMessage.getMessage(message));	
		modelAndView.addObject("teams", teamService.getTeams());
		return modelAndView;
	}
}
