package com.simplilearn.workshop.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.workshop.domain.Product;


public class HomeController {

private static final String BASE_URL = "http://localhost:8080/sports";
	
	private RestTemplate restTemplate;
	
	
	
	public HomeController(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}


	@GetMapping(value ="/sports/home")
	public ModelAndView home() {
		
		
		restTemplate.delete(BASE_URL + "/admin");
		
		ResponseEntity<List<Product>> responseEntity =
				restTemplate.exchange(BASE_URL, HttpMethod.GET,null, new ParameterizedTypeReference<List<Product>>() {
					
				});
		
		
		List<Product> products = responseEntity.getBody();
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		modelAndView.addObject("list", products);
		modelAndView.addObject("pageTitle", "SPORTY SHOES - HOMEPAGE");
		
		return modelAndView;
		
	}

}
