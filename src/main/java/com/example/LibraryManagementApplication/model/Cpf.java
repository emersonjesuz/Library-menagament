package com.example.LibraryManagementApplication.model;

import lombok.Getter;

public class Cpf {
    @Getter
    private final String cpf;
    public Cpf(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("CPF inválido: " + value);
        }
        this.cpf = value;
    }
    private boolean isValid(String cpf) {
        if (cpf == null) return false;

        // remove caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");
        if (cpf.length() != 11) return false;

        // checa se todos os dígitos são iguais (ex: 111.111.111-11)
        if (cpf.chars().distinct().count() == 1) return false;

        try {
            int d1 = 0, d2 = 0;
            for (int i = 0; i < 9; i++) {
                int num = Integer.parseInt(cpf.substring(i, i + 1));
                d1 += num * (10 - i);
                d2 += num * (11 - i);
            }

            int verificador1 = d1 % 11 < 2 ? 0 : 11 - (d1 % 11);
            d2 += verificador1 * 2;
            int verificador2 = d2 % 11 < 2 ? 0 : 11 - (d2 % 11);

            return verificador1 == Integer.parseInt(cpf.substring(9, 10)) &&
                    verificador2 == Integer.parseInt(cpf.substring(10, 11));
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
