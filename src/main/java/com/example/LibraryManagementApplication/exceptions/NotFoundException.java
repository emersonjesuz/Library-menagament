package com.example.LibraryManagementApplication.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends IllegalArgumentException {
    private HttpStatus status = HttpStatus.NOT_FOUND;
    private int statusCode = 404;

    public NotFoundException(String message) {
        super(message);
    }
}
