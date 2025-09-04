package com.example.LibraryManagementApplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(name = "quantity_books")
    private Integer quantityBooks = 0;

    @OneToMany(mappedBy = "client")
    private List<Loan> loans;

    public Client() {
    }

    public Client(String name, String cpf) {
        this.cpf = cpf;
        this.name = name;
    }

    public void incrementQuantityBooks(int quantity) {
        this.quantityBooks = this.quantityBooks + quantity;
    }

    public void decrementQuantityBooks(int quantity) {
        this.quantityBooks = this.quantityBooks - quantity;
    }
}
