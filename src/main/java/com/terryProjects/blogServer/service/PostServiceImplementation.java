package com.terryProjects.blogServer.service;

import com.terryProjects.blogServer.entity.Post;
import com.terryProjects.blogServer.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        post.setLikeCount(0);
        post.setViewCount(0);
        post.setDate(new Date());

        // Save in the DB
        return postRepository.save(post);
    }

    // Method that gets all posts
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    // Method that gets post by Post Id
    public Post getPostById(Long postId){

        //Optional<> -> Used to show that an object may or may not be there
        //  optionalPost can hold a Post object if it is found, or be empty if no post with the given
        // postRepository.findById(postId) -> This method attempts to find a post by its ID.
        Optional<Post> optionalPost = postRepository.findById((postId));
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setViewCount(post.getViewCount() + 1);
            return postRepository.save(post);
        } else{
            throw new EntityNotFoundException("Post Not Found");
        }
    }

}
