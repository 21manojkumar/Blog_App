package com.smart.blog.services;

import java.util.List;

import com.smart.blog.payloads.CategoryDto;

public interface CategoryService {

	//create 
	CategoryDto  createcategory(CategoryDto categoryDto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	//delete
	void deleteCategory(Integer categoryId);
	
	//get
	CategoryDto getCategory(Integer categoryId);
	
	
	
	List<CategoryDto> getCategory();
	
	
}
