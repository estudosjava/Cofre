package br.com.cofrinho.controller;

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
	
	@RequestMapping(value="/addTeam", method=RequestMethod.POST)
	public ModelAndView addingTeam(@ModelAttribute Team team) {
		
		ModelAndView modelAndView = new ModelAndView("teamMaintenance");
		teamService.addTeam(team);
		
		String message = "Equipe inserida com sucesso!";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/listTeam")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("teamList");
		
		List<Team> teams = teamService.getTeams();
		modelAndView.addObject("teams", teams);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{teamId}", method=RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer teamId) {
		ModelAndView modelAndView = new ModelAndView("teamEdit");
		Team team = teamService.getTeam(teamId);
		modelAndView.addObject("team",team);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{teamId}", method=RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute Team team, @PathVariable Integer teamId) {
		
		ModelAndView modelAndView = new ModelAndView("teamMaintenance");
		
		teamService.updateTeam(team);
		
		String message = "Equipe alterada com sucesso!";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{teamId}", method=RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer teamId) {
		ModelAndView modelAndView = new ModelAndView("teamMaintenance");
		teamService.deleteTeam(teamId);
		String message = "Equipe removida com sucesso!";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
}
