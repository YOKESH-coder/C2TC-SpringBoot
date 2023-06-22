package com.cg.asm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.asm.model.Admin;
import com.cg.asm.service.AdminService;

@CrossOrigin(allowedHeaders = "*",origins = "*")
@RestController
public class AdminContoller {
	
	@Autowired
	private AdminService adminService;
	
	//Create
	@PostMapping("/registerAdmin")
	public Admin registerAdmin(@RequestBody Admin admin) {
		return adminService.registerAdmin(admin);
	}

	//Retrieve all
	@GetMapping("/getAdmins")
	public List<Admin> getAdmins(){
		return adminService.getAdmins();
	}
	
	//Delete
	@DeleteMapping("/deleteAdmin")
	public void deleteAdmin(@RequestParam Integer id) {
		adminService.deleteAdmin(id);
	}
	
	//Update
	@PutMapping("/updateAdmin")
	public Admin updateAdmin(@RequestBody Admin admin) {
		return adminService.updateAdmin(admin);
	}
}
