package com.terryProjects.blogServer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Used for auto increment
    private Long id;

    private String content;

    private Date createdAt;

    private String postedBy;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
        private Post post;

    public void setPost(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }


    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
