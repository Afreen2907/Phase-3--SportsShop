package com.simplilearn.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.workshop.domain.Admin;
import com.simplilearn.workshop.domain.User;

public class UserController {

	private static final String BASE_URL = "http://localhost:8080/sports";
	

	private RestTemplate restTemplate;
	
	@Autowired
	public UserController(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	
	//login 
	@GetMapping(path="sports/user")
	public ModelAndView userLogin() {
		ResponseEntity<User> responseEntity =
				restTemplate.exchange(BASE_URL, HttpMethod.GET, null, new ParameterizedTypeReference<User>() {
					
				});
		User user = responseEntity.getBody();
		
		
		if (user == null) {
			ModelAndView modelAndView = new ModelAndView("login");
			modelAndView.addObject("error", " login failed");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("dashboard");
		modelAndView.addObject("pageTitle", "USER DASHBOARD");
		return modelAndView;
	}
	
	//register
	@GetMapping(path="/sports/users/showRegisterForm")
	public ModelAndView showRegisterForm() {
		ModelAndView modelAndView = new ModelAndView("register");
		
		User theUser = new User();
		
		modelAndView.addObject("user", theUser);
		return modelAndView;
	}
	@PostMapping(path="sports/users/registerUser")
	public ModelAndView saveUser(@ModelAttribute("user") User theUser) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sports/home");
		
	restTemplate.postForObject(BASE_URL, theUser, User.class);
	
	return modelAndView;
	}
	
	

}
