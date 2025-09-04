package com.example.LibraryManagementApplication.dtos;

import com.example.LibraryManagementApplication.exceptions.InvalidIsbnException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {
    @NotNull(message = "Campo 'autor' é obrigatorio")
    private String autor;

    @NotNull(message = "Campo 'titulo' é obrigatorio")
    private String title;

    @NotNull(message = "Campo 'ISBN' é obrigatorio")
    private String isbn;

    @NotNull(message = "Campo 'disponivel' é obrigatorio")
    private Boolean available;

    public void setIsbn(@NotNull String isbn) {
        boolean isbnOnlyNumbers = isbn.matches("^\\d+$");
        if (!isbnOnlyNumbers || isbn.length() < 5) {
            throw new InvalidIsbnException();
        }
        this.isbn = isbn;
    }
}
