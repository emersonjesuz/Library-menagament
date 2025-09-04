package com.example.LibraryManagementApplication.dtos;

import com.example.LibraryManagementApplication.validators.CpfValidator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientDto {

    @NotNull(message = "Campo 'nome' é obrigatorio")
    private String name;

    @NotNull(message = "Campo 'CPF' é obrigatorio")
    private String cpf;

    public void setCpf(String cpf) {
        CpfValidator.validate(cpf);
        this.cpf = cpf;
    }
}
