package com.example.LibraryManagementApplication.dtos;

import lombok.Getter;

public class LibraryResponseDto {
    @Getter
    private String message;

    public LibraryResponseDto(String message) {
        this.message = message;
    }
}
