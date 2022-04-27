package com.smart.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.blog.entites.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
