package com.springboot.blog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostCotroller {
	
	private PostService postService;
	
	public PostCotroller(PostService postService) {
		this.postService = postService;
		
	}
	
	//create blog post
	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
		return new ResponseEntity<>(postService.createPost(postDto),HttpStatus.CREATED);
	}

	//get all post REST Api
	@GetMapping
	public List<PostDto> getAllPosts(){
		return postService.getAllPosts();
	}
}
