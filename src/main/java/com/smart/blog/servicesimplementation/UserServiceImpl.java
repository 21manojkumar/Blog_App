package com.smart.blog.servicesimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.blog.entites.User;
import com.smart.blog.exceptions.*;
import com.smart.blog.payloads.UserDto;
import com.smart.blog.repositories.UserRepo;
import com.smart.blog.services.UserServices;


@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepo userRepo;
	private ModelMapper modelmapper;
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		//this.userRepo.save(user);
		
	User user =this.dtoToUser(userDto);	
	User savedUser = this.userRepo.save(user);	
		
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		
		User user=this.userRepo.findById(userId).orElseThrow(() -> new
				ResourceNotFoundException("User","Id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updateUser=this.userRepo.save(user);
	UserDto	userDto1=this.userToDto(updateUser);
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		
		User user=this.userRepo.findById(userId).orElseThrow(() -> new
				ResourceNotFoundException("User","Id",userId));
		
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		
		List<User> users= this.userRepo.findAll();
		List<UserDto>userDtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

		User user=this.userRepo.findById(userId).orElseThrow(() -> new
				ResourceNotFoundException("User","Id",userId));
		
	this.userRepo.deleteById(userId);
		}
	
	
	
	
	private User dtoToUser(UserDto userDto)
	{
		
		User user = this.modelmapper.map(userDto,User.class);
		
		 
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		
		return user;
		
	}
	private UserDto userToDto(User user)
	{
		
		UserDto userDto = this.modelmapper.map(user, UserDto.class); 
//	//	user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
//		
		return userDto  ;
		
	}
}
