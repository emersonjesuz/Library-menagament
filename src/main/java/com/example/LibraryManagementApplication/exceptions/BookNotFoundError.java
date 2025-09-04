package com.example.LibraryManagementApplication.exceptions;

public class BookNotFoundError extends NotFoundException {
    public BookNotFoundError() {
        super("Livro não encontrado");
    }

    public BookNotFoundError(String message) {
        super(message);
    }
}
