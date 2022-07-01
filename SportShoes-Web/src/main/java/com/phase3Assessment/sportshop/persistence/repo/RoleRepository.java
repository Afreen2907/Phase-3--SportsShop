package com.phase3Assessment.sportshop.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phase3Assessment.sportshop.persistence.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}