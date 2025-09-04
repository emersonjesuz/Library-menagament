package com.example.LibraryManagementApplication.services;

import com.example.LibraryManagementApplication.dtos.BookDto;
import com.example.LibraryManagementApplication.exceptions.ExistsBookException;
import com.example.LibraryManagementApplication.exceptions.ExistsIsbnException;
import com.example.LibraryManagementApplication.model.Book;
import com.example.LibraryManagementApplication.repositories.BookRepository;
import com.example.LibraryManagementApplication.validators.ExistsBookValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final ExistsBookValidator existsBookValidator;

    public BookService(BookRepository bookRepository, ExistsBookValidator existsBookValidator) {
        this.bookRepository = bookRepository;
        this.existsBookValidator = existsBookValidator;
    }

    public Book create(BookDto input) {
        if (this.bookRepository.existsByIsbn(input.getIsbn())) {
            throw new ExistsIsbnException();
        }
        Book book = new Book(input.getAutor(), input.getTitle(), input.getIsbn(), input.getAvailable());
        return this.bookRepository.save(book);
    }

    public Book find(Long bookId) {
        return this.existsBookValidator.validateById(bookId);
    }

    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    public Book update(BookDto input, Long bookId) {
        Book book = this.existsBookValidator.validateById(bookId);
        if (!Objects.equals(input.getIsbn(), book.getIsbn())) {
            if (this.bookRepository.existsByIsbn(input.getIsbn())) {
                throw new ExistsBookException();
            }
        }
        book.setTitle(input.getTitle());
        book.setAutor(input.getAutor());
        book.setIsbn(input.getIsbn());
        return this.bookRepository.save(book);
    }

    public void delete(Long bookId) {
        this.existsBookValidator.validateById(bookId);
        this.bookRepository.deleteById(bookId);
    }
}
