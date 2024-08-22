package com.springboot.blog.service.impl;

import org.springframework.stereotype.Service;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	private PostRepository postRepository;
	
	public PostServiceImpl(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}


	@Override
	public PostDto createPost(PostDto postDto) {
		
		//Convert DTO to entity
		Post post = new Post();
	    post.setTitle(post.getTitle());
	    post.setDescription(post.getDescription());
	    post.setContent(postDto.getContent());
	    
	    Post newPost = postRepository.save(post);
	    
	    //convert entity to Dto
	    PostDto postResponse = new PostDto();
	    postResponse.setId(newPost.getId());
	    postResponse.setTitle(newPost.getTitle());
	    postResponse.setDescription(newPost.getDescription());;
	    postResponse.setContent(newPost.getContent());
	    
		return postResponse;
	}

}
