package com.example.mappingfeb.controller;

import com.example.mappingfeb.entity.Post;
import com.example.mappingfeb.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping ("/create")
    public ResponseEntity<Post> createPost(@ RequestBody Post post){
       Post savePost=postRepository.save(post);
        return new ResponseEntity<>(savePost, HttpStatus.CREATED);
    }
}
