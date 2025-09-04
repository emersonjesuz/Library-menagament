package com.example.LibraryManagementApplication.exceptions;

public class ExistsBookException extends BadRequestException {
    public ExistsBookException() {
        super("Livro já existe");
    }
}
