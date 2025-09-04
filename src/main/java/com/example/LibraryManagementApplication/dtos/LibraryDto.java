package com.example.LibraryManagementApplication.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LibraryDto {
    @NotNull(message = "Indetificador do cliente obrigatorio")
    private Long clientId;

    @NotNull(message = "Indetificador do Livro obrigatorio")
    private Long bookId;
}

