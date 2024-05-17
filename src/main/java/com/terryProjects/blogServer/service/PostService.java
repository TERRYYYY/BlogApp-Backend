package com.terryProjects.blogServer.service;

import com.terryProjects.blogServer.entity.Post;

import java.util.List;

public interface PostService {
    Post savePost (Post post);

    List<Post> getAllPosts();
}
