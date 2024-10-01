package com.alexk.spring_book_library;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name of the book is required.")
    private String name;

    @NotBlank(message = "Author of the book is required.")
    private String author;

    private int pages;
    private String isbn;

    @Enumerated(EnumType.STRING)
    private BookGenre genre = BookGenre.OTHER;

    public Book() {
    }

    public Book(Long id, String name, String author, int pages, String isbn, BookGenre genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
        this.genre = (genre != null) ? genre : BookGenre.OTHER;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }
}
