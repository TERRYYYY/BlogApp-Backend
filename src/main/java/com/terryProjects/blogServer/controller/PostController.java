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

// CrossOrigin -> Used when trying to fetch or interact with resources from another domain
@CrossOrigin(origins = "*")
public class PostController {

    //@Autowired -> Automatically wires required dependencies
    @Autowired
    private PostService postService;

    //Let's write our endpoint

    //Endpoint To Create New Posts
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

    //Endpoint To Get All Posts
    @GetMapping  // -> Handles GET request methods
    public ResponseEntity<List<Post>> getAllPosts  (){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Endpoint To Get Post By ID
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

    //Endpoint To Get Post's Likes
    @PutMapping("/{postId}/like")
    public ResponseEntity<?> likePost(@PathVariable Long postId){
        try{
            postService.likePost(postId);
            return ResponseEntity.ok(new String[]{"Post Liked Successfully"});
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    //Endpoint to update posts
    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable Long postId, @RequestBody Post post){
        Post existingPost = postService.getPostById(postId);
        if (existingPost == null){
            return ResponseEntity.notFound().build();
        }

        existingPost.setName(post.getName());
        existingPost.setContent(post.getContent());
        existingPost.setPostedBy(post.getPostedBy());
        existingPost.setImg(post.getImg());

        Post updatePost = postService.updatePost(existingPost);
        return ResponseEntity.ok(updatePost);
    }
}
