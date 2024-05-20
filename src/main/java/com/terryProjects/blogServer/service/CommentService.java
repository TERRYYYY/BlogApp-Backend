package com.terryProjects.blogServer.service;

import com.terryProjects.blogServer.entity.Comment;

public interface CommentService {

    //Create New Comment
    Comment createComment(Long postId, String postedBy, String content);
}
