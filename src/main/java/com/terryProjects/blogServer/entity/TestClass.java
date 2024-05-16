package com.terryProjects.blogServer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@Entity annotation -> Signals the JPA provider to tell them that the class should be treated as a table in a database
@Entity
public class TestClass {

    // @Id annotation -> Used to indicate the primary key of an entity
    @Id
    private Long id;
}
