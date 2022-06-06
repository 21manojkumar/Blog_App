package com.smart.blog.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.stylesheets.MediaList;

import com.smart.blog.config.AppConstants;
import com.smart.blog.entites.Post;
import com.smart.blog.payloads.ApiResponse;
import com.smart.blog.payloads.PostDto;
import com.smart.blog.payloads.PostResponce;
import com.smart.blog.services.FileService;
import com.smart.blog.services.PostService;


@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
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
	public ResponseEntity<PostResponce> getAllPost(
	@RequestParam(value = "pageNumber",defaultValue=AppConstants.PAGE_NUMBER,required = false )Integer pageNumber,
	@RequestParam(value = "pageSize",defaultValue =AppConstants.PAGE_SIZE ,required = false )Integer pageSize,
	@RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY,required = false)String sortBy
			
			)
	{
		PostResponce postResponce = this.postService.getAllPost(pageNumber,pageSize, sortBy);
		return new ResponseEntity<PostResponce>(postResponce,HttpStatus.OK);
		
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

	
		//serching
	
	@GetMapping("/post/serch/{keywords}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(
			@PathVariable("keywords") String keywords
			){
		
		List<PostDto> result=this.postService.serchPosts(keywords);
		
		return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);
		
	}
	
	//Image file upload 
	@PostMapping("post/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(@RequestParam("image")MultipartFile image,
			@PathVariable Integer postId
			)throws IOException 
	{
	String fileName =this.fileService.uploadImage(path, image);
	PostDto postDto=this.postService.getPostById(postId);
	
	postDto.setImageName(fileName);
	PostDto updatePost=this.postService.updatePost(postDto, postId);
	
	return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	}
	 
	//method to serve files
	
	@GetMapping(value="post/image/{imageName}",produces=MediaType.IMAGE_GIF_VALUE )
	public void downloadImage( @PathVariable("imageName") String imageName,
			HttpServletResponse response
			)throws IOException{
		
		InputStream resource= this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
		
	}	
	
	
}
	

