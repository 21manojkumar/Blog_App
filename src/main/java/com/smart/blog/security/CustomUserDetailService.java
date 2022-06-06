package com.smart.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smart.blog.entites.User;
import com.smart.blog.exceptions.ResourceNotFoundException;
import com.smart.blog.repositories.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//loading user from  database by useraName 
		
	User user=this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("user", "email"+username,0	));
		
		
		return user;
	}

}
