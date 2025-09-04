package com.example.LibraryManagementApplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDateTime loanDate = LocalDateTime.now();

    private LocalDateTime returnAt = null;

    private boolean returned = false;

    public Loan() {

    }

    public Loan(Client client, Book book) {
        this.client = client;
        this.book = book;
    }

    public void setReturned(boolean returned) {
        this.returnAt = LocalDateTime.now();
        this.returned = returned;
    }

    public Long getClientId() {
        return client.getId();
    }

    public Long getBookId() {
        return book.getId();
    }
}
