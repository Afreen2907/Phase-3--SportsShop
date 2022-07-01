package com.simplilearn.workshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmailIdAndPwd(String emailId, String pwd);
	
	User findByEmailId(String emailId);
	

}
