package com.smart.blog.payloads;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.smart.blog.entites.Post;

public class CommentsDto {

	private  int id;
	
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CommentsDto(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
	
	
}
