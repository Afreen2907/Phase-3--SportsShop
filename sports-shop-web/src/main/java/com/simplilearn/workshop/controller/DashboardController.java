package com.simplilearn.workshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class DashboardController {

	@GetMapping(value="/sports/dashboard")
	public ModelAndView dashboard() {
		
		ModelAndView mod = new ModelAndView("dashboard");
		mod.addObject("pageTitle", "SPORTY SHOES - DASHBOARD");
		return  mod;
	}

}
