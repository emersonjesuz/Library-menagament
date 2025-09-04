package com.example.LibraryManagementApplication.exceptions;

public class ReservationNotUnavailableException extends BadRequestException {
    public ReservationNotUnavailableException() {
        super("Livro indisponivel");
    }
}
