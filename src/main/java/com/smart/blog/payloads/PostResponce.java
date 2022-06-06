package com.smart.blog.payloads;

import java.util.List;

public class PostResponce {
	
	
	private List<PostDto>	content;
	private int pageNumber;
	private int pageSize;
	private int totalElements;
	private int totalPage;
	
	private boolean lastPage;

	public PostResponce(List<PostDto> content, int pageNumber, int pageSize, int totalElements, int totalPage,
			boolean lastPage) {
		super();
		this.content = content;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPage = totalPage;
		this.lastPage = lastPage;
	}

	public PostResponce() {
		// TODO Auto-generated constructor stub
	}

	public List<PostDto> getContent() {
		return content;
	}

	public void setContent(List<PostDto> content) {
		this.content = content;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	
	
	
	
}
