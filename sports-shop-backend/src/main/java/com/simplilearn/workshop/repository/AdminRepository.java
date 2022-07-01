package com.simplilearn.workshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.simplilearn.workshop.domain.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	Admin findByAdminIdAndPwd(String adminId, String pwd);
	
	Admin findByAdminIdAndId(String adminId, long id);

}
