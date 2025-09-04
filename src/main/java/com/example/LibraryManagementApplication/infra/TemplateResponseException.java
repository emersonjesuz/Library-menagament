package com.example.LibraryManagementApplication.infra;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter
@Getter
public class TemplateResponseException {
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private HttpStatus status;
    private int statusCode;

    public TemplateResponseException(String message, HttpStatus status, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.status = status;
    }
}
