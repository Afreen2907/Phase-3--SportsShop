package com.phase3Assessment.sportshop.persistence.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phase3Assessment.sportshop.persistence.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional <User>  findUserByEmail(String email);
}
