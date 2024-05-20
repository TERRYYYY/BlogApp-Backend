package com.terryProjects.blogServer.controller;

import com.terryProjects.blogServer.entity.Comment;
import com.terryProjects.blogServer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// @RestController -> Creates RESTful web services and consumes JSON data
@RestController

//@RequestMapping -> Handles requests from any HTTP response
@RequestMapping("/api")

// CrossOrigin -> Used when trying to fetch or interact with resources from another domain
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    //Our Endpoints
    // Endpoint to create new comment
    @PostMapping("/comments/create")
    public ResponseEntity<?> createComment (@RequestParam Long postId, @RequestParam String postedBy, @RequestBody String content){
        try{
            return ResponseEntity.ok(commentService.createComment(postId, postedBy, content));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    //Endpoint to get all comments of each comment
    @GetMapping("/comments/{postId}")
    public ResponseEntity<?> getCommentsById(@PathVariable Long postId){
        try{
            return ResponseEntity.ok(commentService.getCommentByPostId(postId));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");
        }
    }
}
