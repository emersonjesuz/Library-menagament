package com.example.LibraryManagementApplication.infra;

import com.example.LibraryManagementApplication.exceptions.BadRequestException;
import com.example.LibraryManagementApplication.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponseException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        TemplateResponseException template = new TemplateResponseException(message, status, status.value());
        return ResponseEntity.status(status).body(template);
    }

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<TemplateResponseException> handlerNotFoundException(NotFoundException ex) {
        TemplateResponseException template = new TemplateResponseException(ex.getMessage(), ex.getStatus(), ex.getStatusCode());
        return ResponseEntity.status(ex.getStatusCode()).body(template);
    }

    @ExceptionHandler(BadRequestException.class)
    private ResponseEntity<TemplateResponseException> handlerBadRequestException(BadRequestException ex) {
        TemplateResponseException template = new TemplateResponseException(ex.getMessage(), ex.getStatus(), ex.getStatusCode());
        return ResponseEntity.status(ex.getStatusCode()).body(template);
    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<TemplateResponseException> handlerBadRequestException(RuntimeException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        TemplateResponseException template = new TemplateResponseException("Error Interno", status, status.value());
        return ResponseEntity.status(status).body(template);
    }
}
