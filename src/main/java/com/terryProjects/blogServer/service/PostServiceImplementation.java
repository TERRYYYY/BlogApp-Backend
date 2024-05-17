package com.terryProjects.blogServer.service;

import com.terryProjects.blogServer.entity.Post;
import com.terryProjects.blogServer.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

// @Service -> Used with classes that provide business functionalities
@Service

//Implements -> Used with classes to inherit properties from interfaces
public class PostServiceImplementation implements PostService{

    //Let's inject the Repository here

    //@Autowired -> Used to automatically wire the required dependencies
    @Autowired
    private PostRepository postRepository;

    // A method to save the post
    public Post savePost (Post post){
        //Setting variables
        post.setLikeCount(String.valueOf(0));
        post.setViewCount(String.valueOf(0));
        post.setDate(new Date());

        // Save in the DB
        return postRepository.save(post);
    }

    // Method that gets all posts
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

}
