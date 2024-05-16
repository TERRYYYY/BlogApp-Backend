package com.terryProjects.blogServer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

// @Entity -> Signals the JPA and tells them to treat this class as a table in the database
@Entity

//@Data annotation -> Shortcut to get the Getter and Setter
@Data
public class Post {

    // @Id -> Set it as the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Used for auto increment
    private Long id;

    private String name;

    // @Column -> Used to define the length of a column
    @Column (length = 5000)
    private String content;

    private String postedBy;

    private String img;

    private Date date;

    private String likeCount;

    private String viewCount;

    private List<String> tags;





    //Properties
    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
