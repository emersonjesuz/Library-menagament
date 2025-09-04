package com.example.LibraryManagementApplication.validators;

import com.example.LibraryManagementApplication.model.Cpf;

public class CpfValidator {
    public static void validate(String cpf) {
        new Cpf(cpf);
    }
}
