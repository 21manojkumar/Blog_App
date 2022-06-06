package com.smart.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.blog.entites.HrUser;
import com.smart.blog.services.HrServices;

@RestController
@RequestMapping("api/hr")
public class HrController {

	@Autowired
	private HrServices hrServices;
	
	@PostMapping("/")
	public ResponseEntity<HrUser> createHrUser(@RequestBody HrUser hrUser){
		
		HrUser hrUsers=this.hrServices.createHrUser(hrUser);
		
	return new ResponseEntity<HrUser>(hrUsers,HttpStatus.CREATED);
	}	
	
	@GetMapping("/{hrId}")
	public ResponseEntity<HrUser>getHrUser(@PathVariable Integer hrId){
		
		HrUser hrUser=this.hrServices.getHrUser(hrId);
		
			
		return new ResponseEntity<HrUser>(hrUser,HttpStatus.OK);
	}
	
	
}
