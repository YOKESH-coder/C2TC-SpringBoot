package com.cg.asm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.asm.model.Admin;
import com.cg.asm.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	public Admin registerAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public List<Admin> getAdmins(){
		return (List<Admin>) adminRepository.findAll();
	}
	
	public void deleteAdmin(Integer id) {
		adminRepository.deleteById(id);
	}
	
	public Admin updateAdmin(Admin admin) {
		Integer id = admin.getId();
		Admin ad = adminRepository.findById(id).get();
		ad.setName(admin.getName());
		ad.setPassword(admin.getPassword());
		ad.setPhone(admin.getPhone());
		return adminRepository.save(ad);
	}
}
