package com.cg.asm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminService {
	
	@Autowired
	private AdminRepository adrepo;
	
	//RetrieveAll
	public List listAll() {
		return adrepo.findAll();
	}
	
	//RetrieveByid and Update 
	public Admin get(Integer id) {
		return adrepo.findById(id).get();	
	}
	
	//Create and Update
	public void save(Admin admin) {
		adrepo.save(admin);
	}
	
	//Delete
	public void delete(Integer id) {
		adrepo.deleteById(id);
	}
	
}
