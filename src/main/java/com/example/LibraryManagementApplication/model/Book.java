package com.example.LibraryManagementApplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false, unique = true)
    private String isbn;

    private Boolean available = true;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans;

    public Book() {
    }

    public Book(String title, String author, String isbn, Boolean available) {
        this.autor = author;
        this.title = title;
        this.isbn = isbn;
        this.available = available;
    }
}
