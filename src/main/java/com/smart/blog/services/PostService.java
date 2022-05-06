package com.smart.blog.services;

import java.util.List;

import com.smart.blog.entites.Post;
import com.smart.blog.payloads.PostDto;

public interface PostService {

	
	//create
	PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
	
	//Update
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all Posts
	List<PostDto>getAllPost();
	
	//get single post
	PostDto getPostById(Integer postId);
	
	// get all post by category
	
	List<PostDto>getPostsByCategory(Integer categoryId);
	
	
	//get all post by user
	List<PostDto>getPostsByUser(Integer userId);
	
	//search post 
	List<Post>serchPosts(String keyword);

	//Post createPost(PostDto postDto, );
	
	
	
	
	
	
}
