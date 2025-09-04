package com.example.LibraryManagementApplication.exceptions;

public class ClientNotFoundError extends NotFoundException {
    public ClientNotFoundError() {
        super("Cliente não encontrado");
    }

    public ClientNotFoundError(String message) {
        super(message);
    }
}
