package com.terryProjects.blogServer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

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

    private String content;



}
