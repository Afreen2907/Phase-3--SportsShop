package com.simplilearn.workshop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.workshop.domain.Admin;

@Controller
public class AdminController {

	private static final String BASE_URL = "http://localhost:8080/sports";
	

	private RestTemplate restTemplate;

	@Autowired
	public AdminController(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	
	@GetMapping(path="/sports/admin")
	public ModelAndView adminLogin() {
		
		
		ResponseEntity<Admin> responseEntity =
				restTemplate.exchange(BASE_URL, HttpMethod.GET, null, new ParameterizedTypeReference<Admin>() {
					
				});
		Admin admin = responseEntity.getBody();
		
		
		if (admin == null) {
			ModelAndView modelAndView = new ModelAndView("admin/login");
			modelAndView.addObject("error", "Admin login failed");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("admin/dashboard");
		modelAndView.addObject("pageTitle", "ADMIN DASHBOARD");
		return modelAndView;
	}
	
	@GetMapping(path="/sports/admin/changePassword")
	public ModelAndView changePwd() {
		
		
		ResponseEntity<Admin> responseEntity =
				restTemplate.exchange(BASE_URL, HttpMethod.GET, null, new ParameterizedTypeReference<Admin>() {
					
				});
		Admin admin = responseEntity.getBody();
		
		
		if (admin == null) {
			ModelAndView modelAndView = new ModelAndView("admin/login");
			
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("admin/dashboard");
		modelAndView.addObject("admin", admin);
		modelAndView.addObject("pageTitle", "ADMIN CHANGE PASSWORD");
		return modelAndView;
	}
	
	@PostMapping(path="/sports/admin/updatePassword")
	public ModelAndView UpdatePassword(@RequestParam (value="pwd", required=true) String pwd,
			@RequestParam(value="pwd2", required=true) String pwd2, javax.servlet.http.HttpServletRequest request, Model theModel) {
		HttpSession session = request.getSession();
		if(session.getAttribute("admin_id") == null) {
			return new ModelAndView("admin/login");
		}
		ModelAndView mod = new ModelAndView("admin/change-password");
		if (pwd == null || pwd2 == null || pwd.equals("") || pwd2.equals("")) {
			
			mod.addObject("error", "Error , Incomplete passwords submitted.");
			  return mod;
		  }
		  if (!pwd.equals(pwd2)) {
			  mod.addObject("error", "Error , Passwords do not match.");
			  return mod;
		  }
		  
		  Map<String, String> params = new HashMap<>();
		 
		  params.put("adminId", (String) session.getAttribute("admin_id"));
		  params.put("pwd", pwd);
		  Admin theAdmin = restTemplate.postForObject(BASE_URL, "/{adminId}", Admin.class, params);
		  theModel.addAttribute("admin", theAdmin);
		  
		  return new ModelAndView("admin/dashboard");
	}
	

}
