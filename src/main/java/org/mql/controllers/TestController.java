package org.mql.controllers;

import java.util.List;
import java.util.Vector;

import org.mql.dao.FormationRepository;
import org.mql.dao.MemberRepository;
import org.mql.dao.ModuleRepository;
import org.mql.dao.StreamingRepository;
import org.mql.dao.TimingRepository;
import org.mql.models.Formation;
import org.mql.models.Member;
import org.mql.models.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@Autowired
	FormationRepository formationRepository;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	StreamingRepository streamingRepository;

	@Autowired
	TimingRepository timingRepository;

	@GetMapping(path = "/add")
	public @ResponseBody String addNewUser() {
		List<Formation> formations= new Vector<>();
		formations.add(new Formation("Java"));
		formations.add(new Formation("C++"));
		formations.add(new Formation("Génie Logiciel"));
		formations.add(new Formation("Oracle"));
		formations.add(new Formation("Qualité Logiciel"));
		formations.add(new Formation("Spring"));
		
		formationRepository.saveAll(formations);
		return "Saved";
	}

	@GetMapping("/greeting")
	public String greeting() {

		return "greeting";
	}

	@GetMapping("/")
	public String home() {
		return "main_views/home";
	}

	@GetMapping("/formations")
	public String formation() {
		return "main_views/formations";
	}
	
	@GetMapping("/articles")
	public String articles() {
		return "main_views/articles";
	}
	
	@GetMapping("/contacts")
	public String contacts() {
		return "main_views/contacts";
	}
	
	@GetMapping("/login")
	public String login() {
		return "main_views/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "main_views/register";
	}

	@GetMapping(path = "/allMembers")
	public @ResponseBody String getAllMembers() {
		return memberRepository.findAll().toString();
	}

	@GetMapping(path = "/allFormations")
	public @ResponseBody String getAllFormations() {
		return formationRepository.findAll().toString();
	}

	@GetMapping(path = "/allModules")
	public @ResponseBody String getAllModules() {

		return moduleRepository.findAll().toString();
	}

	@GetMapping(path = "/allStreamings")
	public @ResponseBody String getAllStreamings() {
		return streamingRepository.findAll().toString();
	}

	@GetMapping(path = "/allTimings")
	public @ResponseBody String getAllTimings() {
		return timingRepository.findAll().toString();
	}

	@GetMapping(path = "/delete")
	public @ResponseBody String delete() {
		formationRepository.deleteAll();
		return "deleted";
	}

}
