package com.smart.blog.services;

import com.smart.blog.entites.HrUser;

public interface HrServices {
	
	
	//create 
	HrUser createHrUser(HrUser hrUser);
	
	//get_hrUser
	HrUser getHrUser(Integer hrId);
	

}
