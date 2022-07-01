package com.phase3Assessment.sportshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.phase3Assessment.sportshop.persistence.model.CustomUserDetail;
import com.phase3Assessment.sportshop.persistence.model.User;
import com.phase3Assessment.sportshop.persistence.repo.UserRepository;



@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user=userRepository.findUserByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException("USER is Not Found"));
		
		return user.map(CustomUserDetail::new).get();
	}

	
	
}


// userrepostory se fetch kro aur return kro