package com.example.LibraryManagementApplication.exceptions;

public class BookAlreadyReturnedException extends BadRequestException {
    public BookAlreadyReturnedException() {
        super("Livro já devolvido");
    }
}