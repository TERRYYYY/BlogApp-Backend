package com.terryProjects.blogServer.repository;

import com.terryProjects.blogServer.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository -> Indicates that the class can do retrival, searching, updating  & deleting of objects
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    //Retrieve all comments from each post
    List<Comment> findByPostId(Long postId);
}
