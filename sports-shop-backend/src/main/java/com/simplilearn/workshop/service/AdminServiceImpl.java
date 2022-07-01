package com.simplilearn.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.domain.Admin;
import com.simplilearn.workshop.repository.AdminRepository;

@Service(value="adminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	public AdminServiceImpl() {
		
	}

	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		System.out.println("spring container called constructor to  assemble 'adminRepository' bean");
		this.adminRepository = adminRepository;
	}

	@Override
	public Admin authenticate(String adminId, String pwd) {
		// TODO Auto-generated method stub
		return adminRepository.findByAdminIdAndPwd(adminId, pwd);
	}

	@Override
	public Admin getAdminByIds(String adminId, long id) {
		// TODO Auto-generated method stub
		return adminRepository.findByAdminIdAndId(adminId, id);
	}

	@Override
	public Admin updatePwd(Admin admin) {
		return adminRepository.save(admin);
		
	}

	
	
}
