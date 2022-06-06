package com.smart.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.smart.blog.entites.Category;
import com.smart.blog.entites.Comment;
import com.smart.blog.entites.User;

public class PostDto {
	
	
	
	private String title;
	private String contnet;
	private String imageName="default.png";
	

	//private String content;
	//private String imagename;
	private Date addDate;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne
	private User user;
	
	
	private Set<CommentsDto> comments=new HashSet<>();
	
	
	
	
	
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContnet() {
		return contnet;
	}
	public void setContnet(String contnet) {
		this.contnet = contnet;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public PostDto(String title, String contnet, String imageName) {
		super();
		this.title = title;
		this.contnet = contnet;
		this.imageName = imageName;
	}

	
	
}
