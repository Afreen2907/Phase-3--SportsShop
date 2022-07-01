package com.simplilearn.workshop.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.workshop.domain.User;
import com.simplilearn.workshop.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	
	@PostMapping(path="/sports/loginUsers/")
	@ResponseBody
	public ResponseEntity<User> userLogin(@RequestParam(name="emailId") String emailId, @RequestParam(name="pwd")String adminPwd){
		
		User authenticateUser = userService.authenticate(emailId, adminPwd);
		
		if(authenticateUser == null) {
			System.out.println("No Admin found");
			return new ResponseEntity("No Admin User found", HttpStatus.OK);
		}else {
			URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{emailId}/adminDashboard")
					.buildAndExpand(authenticateUser.getEmailId())
					.toUri();
			
			return ResponseEntity.created(location).build();
		}
	}
	
	@PostMapping(path="/sports/registerUser")
	
	public ResponseEntity<User> register(@Valid @RequestBody User user) {
		User newUser = userService.updateUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{emailId}").buildAndExpand(newUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}

}
