package com.terryProjects.blogServer.controller;

import com.terryProjects.blogServer.entity.Post;
import com.terryProjects.blogServer.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Rest controller -> Used to create RESTful web services & consumes JSON data
@RestController

// @RequestMapping -> Handles requests of any HTTP method
@RequestMapping ("/api/posts")

@CrossOrigin(origins = "*")
public class PostController {

    //@Autowired -> Automatically wires required dependencies
    @Autowired
    private PostService postService;

    //Let's write our endpoint

    //Method to create new posts
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

    //Method to get all posts
    @GetMapping  // -> Handles GET request methods
    public ResponseEntity<List<Post>> getAllPosts  (){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Method to get post by ID
    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostById (@PathVariable Long postId){
        try{
            Post post = postService.getPostById(postId);
            return ResponseEntity.ok(post);
        }
        catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //Method to get Post's likes
    @PutMapping("/{postId}/like")
    public ResponseEntity<?> likePost(@PathVariable long postId){
        try{
            postService.likePost(postId);
            return ResponseEntity.ok(new String[]{"Post Liked Successfully"});
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
