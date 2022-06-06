package com.smart.blog.services;

import com.smart.blog.payloads.CommentsDto;

public interface CommnetService {

	CommentsDto createCommnet(CommentsDto commnetDto,Integer PostID);
	void deleteComment(Integer commentId);


}
