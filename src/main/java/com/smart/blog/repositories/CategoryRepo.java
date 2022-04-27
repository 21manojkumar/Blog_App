package com.smart.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.blog.entites.Category;


@Repository
public interface CategoryRepo extends JpaRepository< Category, Integer> {

	
	
	
}
