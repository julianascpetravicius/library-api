package com.library.models;

import jakarta.persistence.*;

@Entity
@Table(name = "AUTHOR")
public class Author {

    @Id
    @Column(name = "AUTHOR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "AUTHOR_NAME")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
