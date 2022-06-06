package com.smart.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.blog.entites.HrUser;

public interface HrUserRepo extends JpaRepository<HrUser,Integer> {

	List<HrUser> findByHrId(Integer hrId);
	
}
