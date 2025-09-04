package com.example.LibraryManagementApplication.controllers;

import com.example.LibraryManagementApplication.dtos.BookDto;
import com.example.LibraryManagementApplication.model.Book;
import com.example.LibraryManagementApplication.services.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    public Book create(@RequestBody @Valid BookDto body) {
        return this.bookService.create(body);
    }

    @GetMapping(path = "/{clientId}")
    public Book find(@PathVariable Long clientId) {
        return this.bookService.find(clientId);
    }

    @GetMapping()
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    @PutMapping(path = "/{bookId}")
    public Book update(@RequestBody @Valid BookDto book, @PathVariable Long bookId) {
        return this.bookService.update(book, bookId);
    }

    @DeleteMapping(path = "/{bookId}")
    public void delete(@PathVariable Long bookId) {
        this.bookService.delete(bookId);
    }
}
