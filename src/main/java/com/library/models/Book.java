package com.library.models;

import jakarta.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @Column(name = "BOOK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "BOOK_TITLE")
    private String title;

    @Column(name = "BOOK_ISBN")
    private String isbn;

    @Column(name = "BOOK_PRICE")
    private Double price;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
