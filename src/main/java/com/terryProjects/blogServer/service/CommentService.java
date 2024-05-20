package com.terryProjects.blogServer.service;

import com.terryProjects.blogServer.entity.Comment;

import java.util.List;

public interface CommentService {

    //Create New Comment
    Comment createComment(Long postId, String postedBy, String content);

    // Get All Comments
    List<Comment> getCommentByPostId(Long postId);
}
