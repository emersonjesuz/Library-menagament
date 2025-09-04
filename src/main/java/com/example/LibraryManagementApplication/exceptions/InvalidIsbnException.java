package com.example.LibraryManagementApplication.exceptions;

public class InvalidIsbnException extends BadRequestException {
    public InvalidIsbnException() {
        super("ISBN invalido");
    }
}
