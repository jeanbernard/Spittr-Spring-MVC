package com.spittr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spittr.domain.User;
import com.spittr.repository.SpittleRepositoryImpl;
import com.spittr.repository.UserRepositoryImpl;

@Controller
public class SpittrController {
	
	private SpittleRepositoryImpl spittleRepository;
	private UserRepositoryImpl userRepository;
	
	public SpittrController() {
		
	}
	
	@Autowired
	public SpittrController(SpittleRepositoryImpl spittleRepository, UserRepositoryImpl userRepository) {
		this.spittleRepository = spittleRepository;
		this.userRepository = userRepository;
	}
	

	@RequestMapping(value="/spittles", method=RequestMethod.GET)
	public String spittles(Model model){
		model.addAttribute("spittleList", spittleRepository.createSpittleList(3));	
		return "spittles";
	}
	
	/* Taking input via path parameters. Resource oriented controllers */
	
	@RequestMapping(value="/spittle/{spittleId}", method=RequestMethod.GET)
	public String showSpittle(
			@PathVariable("spittleId") long spittleId, 
			Model model){
		model.addAttribute("spittleId", spittleRepository.findSpittle(1l));	
		return "spittle";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String submitRegistrationForm(User user) {
		
		userRepository.saveUser(user);
		
		return "redirect:/register/" + user.getUsername();
		
	}
	
	@RequestMapping(value="register/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(
			@PathVariable("username") String username,
			Model model) {
		User user = userRepository.findUser(1L);
		model.addAttribute(user);
		
		return "profile";
	}

}
