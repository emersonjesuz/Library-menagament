package com.example.LibraryManagementApplication.validators;

import com.example.LibraryManagementApplication.exceptions.BookNotFoundError;
import com.example.LibraryManagementApplication.model.Book;
import com.example.LibraryManagementApplication.repositories.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class ExistsBookValidator {
    private final BookRepository bookRepository;

    public ExistsBookValidator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book validateById(Long bookId) throws BookNotFoundError {
        return this.bookRepository.findById(bookId).orElseThrow(BookNotFoundError::new);
    }
}
