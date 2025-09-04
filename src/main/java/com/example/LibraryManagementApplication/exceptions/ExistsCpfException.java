package com.example.LibraryManagementApplication.exceptions;

public class ExistsCpfException extends BadRequestException {
    public ExistsCpfException() {
        super("CPF já existe");
    }
}
