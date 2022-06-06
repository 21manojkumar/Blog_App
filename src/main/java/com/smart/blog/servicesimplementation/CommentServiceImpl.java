package com.smart.blog.servicesimplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.blog.entites.Comment;
import com.smart.blog.entites.Post;
import com.smart.blog.exceptions.ResourceNotFoundException;
import com.smart.blog.payloads.CommentsDto;
import com.smart.blog.repositories.CommentRepo;
import com.smart.blog.repositories.PostRepo;
import com.smart.blog.services.CommnetService;

@Service
public class CommentServiceImpl implements CommnetService {
	
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentsDto createCommnet(CommentsDto commnetDto, Integer postId) {
		// TODO Auto-generated method stub
		
		Post  post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","PostId",postId));
		Comment comment=this.modelMapper.map(commnetDto, Comment.class);
				
				
		comment.setPost(post);
		
	Comment savedComment =this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentsDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		
		Comment com=this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("comment", "commentId", commentId));
		this.commentRepo.delete(com);
	}

}
