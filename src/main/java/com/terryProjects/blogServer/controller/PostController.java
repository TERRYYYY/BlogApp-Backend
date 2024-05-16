package com.terryProjects.blogServer.controller;

import com.terryProjects.blogServer.entity.Post;
import com.terryProjects.blogServer.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Rest controller -> Used to create RESTful web services & consumes JSON data
@RestController

// @RequestMapping -> Handles requests of any HTTP method
@RequestMapping ("/api/posts")
public class PostController {

    //@Autowired -> Automatically wires required dependencies
    @Autowired
    private PostService postService;

    //Let's write our endpoint

    //This method will return a response entity -> Represents the whole HTTP response; status code, headers & body
    @PostMapping
    public ResponseEntity<Post> createPost (@RequestBody Post post){ //@Requestbody ->Extracts data from HTTP request data and automatically reconstructs it into a java object
        try{
            Post createdPost = postService.savePost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
