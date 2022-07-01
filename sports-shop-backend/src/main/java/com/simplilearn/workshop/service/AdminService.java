package com.simplilearn.workshop.service;

import java.util.List;

import com.simplilearn.workshop.domain.Admin;

public interface AdminService {

	public Admin authenticate(String adminId, String pwd);
	public Admin getAdminByIds(String adminId, long id);
	public Admin updatePwd(Admin admin);
}
