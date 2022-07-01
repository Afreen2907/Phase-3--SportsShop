package com.simplilearn.workshop.service;


import java.util.List;



import com.simplilearn.workshop.domain.User;

public interface UserService {
	public User authenticate(String userId, String pwd);

	public User getUserById(long id);

	public User getUserByEmailId(String emailId);

	public User updateUser(User user);

	public List<User> getAllUsers();
}
