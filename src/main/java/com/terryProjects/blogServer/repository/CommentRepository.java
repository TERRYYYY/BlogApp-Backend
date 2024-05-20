package com.terryProjects.blogServer.repository;

import com.terryProjects.blogServer.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository -> Indicates that the class can do retrival, searching, updating  & deleting of objects
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
