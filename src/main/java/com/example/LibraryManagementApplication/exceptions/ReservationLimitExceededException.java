package com.example.LibraryManagementApplication.exceptions;

public class ReservationLimitExceededException extends BadRequestException {
    public ReservationLimitExceededException() {
        super("Cliente ja atingiu o limit de reserva");
    }
}