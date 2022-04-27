package com.smart.blog.servicesimplementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.smart.blog.entites.Category;
import com.smart.blog.exceptions.ResourceNotFoundException;
import com.smart.blog.payloads.CategoryDto;
import com.smart.blog.repositories.CategoryRepo;
import com.smart.blog.services.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public CategoryDto createcategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		
	Category cat=this.modelmapper.map(categoryDto, Category.class);
		Category addedcat=this.categoryRepo.save(cat);
		return this.modelmapper.map(addedcat,CategoryDto.class) ;
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat=this.categoryRepo.findById(categoryId).
				orElseThrow(()->new ResourceNotFoundException("category","category Id",categoryId));
		
		//cat.set
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
//		
		Category updatecat =  this.categoryRepo.save(cat);
		
		
		return this.modelmapper.map(updatecat,CategoryDto.class) ;
	}

	@Override
	public void deleteCategory(Integer CategoryId) {
		// TODO Auto-generated method stub

		Category cat = this.categoryRepo.findById(CategoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",CategoryId));
			this.categoryRepo.delete(cat);
			
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",categoryId));
			
		
		return this.modelmapper.map(cat,CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategory() {
		// TODO Auto-generated method stub
		
	List<Category> categories	=this.categoryRepo.findAll();
	List<CategoryDto>catdto=categories.stream().map((cat)->this.modelmapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
		
		return catdto;
	}

}
