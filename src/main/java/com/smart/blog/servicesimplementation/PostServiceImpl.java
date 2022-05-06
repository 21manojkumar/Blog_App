package com.smart.blog.servicesimplementation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.blog.entites.Category;
import com.smart.blog.entites.Post;
import com.smart.blog.entites.User;
import com.smart.blog.exceptions.ResourceNotFoundException;
import com.smart.blog.payloads.PostDto;
import com.smart.blog.repositories.CategoryRepo;
import com.smart.blog.repositories.PostRepo;
import com.smart.blog.repositories.UserRepo;
import com.smart.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
		
			
		User user =this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","userId" ,userId)); 
		
		Category category= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "category_Id",categoryId));
		
		
		Post post = this.modelMapper.map(postDto,Post.class);
		post.setImagename("default.png");
		post.setAddDate(new Date());
		
		Post newPost=this.postRepo.save(post);
		
		

		return this.modelMapper.map(newPost,PostDto.class );
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		Post post =this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("postDto", "PostId", postId));
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContnet());
		post.setImagename(postDto.getImageName());
		
		Post updatePost = this.postRepo.save(post);
		return this.modelMapper.map(updatePost,PostDto.class);
		
		
		
		// 	return null;
	}

	@Override
	public void deletePost(Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Post_id", postId));
		this.postRepo.delete(post);

	}
	
	
	
	
	
//allpost
	
	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		List<Post>allPosts=this.postRepo.findAll();
		List<PostDto>postDtos=allPosts.stream().map((post)->this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		
	Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("posts", "Post_id",postId));
		
	
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","category_id" ,categoryId));
	List<Post>	posts=this.postRepo.findByCategory(cat);
	List<PostDto>	postsDto=	posts.stream().map((post->this.modelMapper.map(posts,PostDto.class))).collect(Collectors.toList());
		
		return postsDto;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		// TODO Auto-generated method stub
		
		User  user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","user_id" , userId));
		List<Post> posts=this.postRepo.findByUser(user);
		List<PostDto> postDto=posts.stream().map((post)->this.modelMapper.map(posts, PostDto.class
				)).collect(Collectors.toList());
		
		
		return postDto;
	}

	@Override
	public List<Post> serchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
