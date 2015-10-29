package com.spittr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spittr.repository.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittrController {
	
	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpittrController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String spittles(Model model){
		model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));	
		return "spittles";
	}

}
