package com.terryProjects.blogServer.service;

import com.terryProjects.blogServer.entity.Post;

import java.util.List;

public interface PostService {
    //Save Posts
    Post savePost (Post post);

    //Get All Posts
    List<Post> getAllPosts();

    //Get Post By Post Id
    Post getPostById(Long postId);

    // Get Post's Likes
    void likePost(Long postId);

    //Update post
    Post updatePost(Post post);
}
