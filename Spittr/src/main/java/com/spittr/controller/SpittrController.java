package com.spittr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		return "redirect:spittles";
	}

}
