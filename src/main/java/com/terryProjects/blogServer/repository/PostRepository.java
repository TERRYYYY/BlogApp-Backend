package com.terryProjects.blogServer.repository;

import com.terryProjects.blogServer.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository -> Indicates that the class can do retrival, searching, updating  & deleting of objects
@Repository

// Extends -> Extending functionality of the parent to the sub parent
      // -> We are extending the Post Entity together with its primary key hence: <Post, Long>
public interface PostRepository extends JpaRepository <Post, Long>{
}
