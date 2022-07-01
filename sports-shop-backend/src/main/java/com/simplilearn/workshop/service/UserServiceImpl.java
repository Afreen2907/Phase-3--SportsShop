package com.simplilearn.workshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.simplilearn.workshop.domain.User;
import com.simplilearn.workshop.repository.UserRepository;

@Service(value="userService")
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User authenticate(String userId, String pwd) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailIdAndPwd(userId, pwd);
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public User getUserByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailId(emailId);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		
		return userRepository.save(user);
			
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
