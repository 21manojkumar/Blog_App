package com.smart.blog.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.blog.payloads.ApiResponse;
import com.smart.blog.payloads.UserDto;
import com.smart.blog.services.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {

	//post mapping
	@Autowired
	private UserServices userServices;
	
	@PostMapping("/")
	public ResponseEntity<UserDto>creatUser(@RequestBody UserDto userDto){
		
		UserDto createUserDto =this.userServices.createUser(userDto);
	
		System.out.println(createUserDto);
		
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	}
	
	
	
	
	// Put mapping

	@PutMapping("/{userId}")
	public ResponseEntity<UserDto>updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId")Integer userId)
	{
		UserDto updateUser=this.userServices.updateUser(userDto, userId);
	return ResponseEntity.ok(updateUser);
	
	}
	
	
	// Delete mapping 
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse>deleteUser(@PathVariable("userId")Integer userId)
	{
	this.userServices.deleteUser(userId);
	return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted",true),HttpStatus.OK);
	
	}
	//get mapping 
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		return ResponseEntity.ok(this.userServices.getAllUsers());	
				
	
	}
	
	
	
	
	
	
	
}
