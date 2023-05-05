package com.cg.asm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	//RetrievAall
	@GetMapping("/admin")
	public List list() {
		return service.listAll();
	}
	
	//retrievebyId
	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> get(@PathVariable Integer id) {
		
		try {
			Admin admin = service.get(id);
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//Create
	@PostMapping("/admin")
	public void add(@RequestBody Admin admin) {
		service.save(admin);
	}
	
	@PutMapping("/admin/{id}")
	public ResponseEntity<?> update(@RequestBody Admin admin, @PathVariable Integer id){
		try {
			Admin existadmin = service.get(id);
			service.save(admin);
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete
	@DeleteMapping("/admin/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
