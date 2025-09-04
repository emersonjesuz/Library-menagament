package com.example.LibraryManagementApplication.exceptions;

public class ReservationNotFoundException extends NotFoundException {
    public ReservationNotFoundException() {
        super("Reserva do livro não encontrada");
    }
}