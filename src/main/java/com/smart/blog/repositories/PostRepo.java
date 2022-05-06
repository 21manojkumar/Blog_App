package com.smart.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.blog.entites.Category;
import com.smart.blog.entites.Post;
import com.smart.blog.entites.User;

public interface PostRepo  extends JpaRepository<Post, Integer>{
	
	
	List<Post>findByUser(User user);
	List<Post>findByCategory(Category category);
	
	

}
