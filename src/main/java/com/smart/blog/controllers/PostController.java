package com.smart.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.blog.entites.Post;
import com.smart.blog.payloads.ApiResponse;
import com.smart.blog.payloads.PostDto;
import com.smart.blog.services.PostService;


@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	//create
	@PostMapping("/user/{userId}/category/{categoryId}/posts ")
	public ResponseEntity<PostDto> createPost(
			@RequestBody PostDto postdto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId ){
		
		
		PostDto createPost =this.postService.createPost(postdto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	
	
	//get by user 
	
	@GetMapping({"/user/{userId}/posts"})
	public  ResponseEntity<List<PostDto>>getPostByUser(
			@PathVariable Integer userId){
	List<PostDto> posts= this.postService.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		
	}
	
	//get by category 
	@GetMapping({"/category/{categoryId}/posts"})
	public  ResponseEntity<List<PostDto>>getPostBycategory(
			@PathVariable Integer categoryId){
	List<PostDto> posts= this.postService.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		
	}
	
	////get all Posts
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>>getAllPost()
	{
		List<PostDto> allPost = this.postService.getAllPost();
		return new ResponseEntity<List<PostDto>>(allPost,HttpStatus.OK);
		
	}
	
//get Posts by_id
	@GetMapping("/posts/{postId}")
	public ResponseEntity<List<PostDto>>getAllById(
			@PathVariable Integer postId)
	{
		PostDto postDto=this.postService.getPostById(postId);
		return new ResponseEntity(postDto,HttpStatus.OK);
		 
	}
	
	//delete post
	@DeleteMapping("/post/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		
		return new ApiResponse("Post is successfully deleted ",true);
	}
//update post
	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDto>updatePost(@RequestBody PostDto postDto, @PathVariable Integer PostId){
		PostDto updatePost=this.postService.updatePost(postDto, PostId);
		
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
		
		
		
	}

	
	
}
	

