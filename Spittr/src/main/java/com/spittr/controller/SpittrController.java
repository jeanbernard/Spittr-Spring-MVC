package com.spittr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spittr.repository.SpittleRepositoryImpl;

@Controller
public class SpittrController {
	
	private SpittleRepositoryImpl spittleRepository;
	
	@Autowired
	public SpittrController(SpittleRepositoryImpl spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

	@RequestMapping(value="/spittles", method=RequestMethod.GET)
	public String spittles(Model model){
		model.addAttribute("spittleList", spittleRepository.createSpittleList(3));	
		return "spittles";
	}
	
	@RequestMapping(value="spittle/{spittleId}", method=RequestMethod.GET)
	public String showSpittle(
			@PathVariable("spittleId") long spittleId, 
			Model model){
		model.addAttribute("spittleId", spittleRepository.findSpittle(1l));	
		return "spittle";
	}

}
