package com.terryProjects.blogServer.service;

import com.terryProjects.blogServer.entity.Comment;
import com.terryProjects.blogServer.entity.Post;
import com.terryProjects.blogServer.repository.CommentRepository;
import com.terryProjects.blogServer.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

// @Service -> Used with classes that provide business functionalities
@Service

//Implements -> Used with classes to inherit properties from interfaces
public class CommentImplementation implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;


    //Method to create a new comment
    public Comment createComment(Long postId, String postedBy, String content){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Comment comment = new Comment();

            comment.setPost(optionalPost.get());
            comment.setContent(content);
            comment.setPostedBy(postedBy);
            comment.setCreatedAt(new Date());

            return commentRepository.save(comment);
        }
        throw new EntityNotFoundException(("Post Not Found"));
    }

}
