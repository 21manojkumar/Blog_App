package com.smart.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smart.blog.repositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {
	@Autowired
	private UserRepo userRepo;
	
	
	@Test
	void contextLoads() {
	}
	@Test
	public void repoTest() {
		String className = this.userRepo.getClass().getName();
		String packageName =this.userRepo.getClass().getPackageName();
		System.out.println("class name"+className);
		System.out.println("package name"+packageName);
	}

}
