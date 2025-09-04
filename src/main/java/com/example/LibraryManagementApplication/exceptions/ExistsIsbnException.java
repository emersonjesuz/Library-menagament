package com.example.LibraryManagementApplication.exceptions;

public class ExistsIsbnException extends BadRequestException {
    public ExistsIsbnException() {
        super("ISBN já existe");
    }
}
