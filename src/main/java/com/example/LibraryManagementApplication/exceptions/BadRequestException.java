package com.example.LibraryManagementApplication.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BadRequestException extends IllegalArgumentException {
    private HttpStatus status = HttpStatus.BAD_REQUEST;
    private int statusCode = 400;

    public BadRequestException(String message) {
        super(message);
    }
}
