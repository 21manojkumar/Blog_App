package com.smart.blog.servicesimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.blog.entites.HrUser;
import com.smart.blog.exceptions.ResourceNotFoundException;
import com.smart.blog.repositories.HrUserRepo;
import com.smart.blog.services.HrServices;

@Service
public class HrUserServiesImpl implements HrServices {
	
	@Autowired
	private HrUserRepo hrUserRepo;

	@Override
	public HrUser createHrUser(HrUser hrUser) {
		// TODO Auto-generated method stub
		
		HrUser hruser=this.createHrUser(hrUser);
		HrUser savedHr=this.hrUserRepo.save(hruser);

		
		
		return this.createHrUser(savedHr);
	}

	@Override
	public HrUser getHrUser(Integer hrId) {
		// TODO Auto-generated method stub
		
	HrUser hrUser= this.hrUserRepo.findById(hrId).orElseThrow(()->new ResourceNotFoundException("hrUser", "HrUserId", hrId));
	//HrUser	getHr =this.getHrUser(hrId);
		
		return hrUser;
	}

}
