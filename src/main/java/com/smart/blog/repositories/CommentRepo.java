package com.smart.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.blog.entites.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
