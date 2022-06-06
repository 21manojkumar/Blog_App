package com.smart.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.blog.entites.Comment;
import com.smart.blog.payloads.ApiResponse;
import com.smart.blog.payloads.CommentsDto;
import com.smart.blog.servicesimplementation.CommentServiceImpl;

@RestController
@RequestMapping("/api")
public class CommentController {
	@Autowired
	private CommentServiceImpl commentService ;
	
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentsDto>createComment(@RequestBody CommentsDto comment,@PathVariable Integer postId)
	{
		
	CommentsDto  createComment	=this.commentService.createCommnet(comment, postId);
	
	return new ResponseEntity<CommentsDto>(createComment,HttpStatus.CREATED);
	}

	@DeleteMapping("/comments/{commnetId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commmentId)
	{
		
	this.commentService.deleteComment(commmentId);
	return new ResponseEntity<ApiResponse>(new ApiResponse("deleted succesfully", true),HttpStatus.OK);
	}
	
}
