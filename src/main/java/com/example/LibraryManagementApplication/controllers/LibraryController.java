package com.example.LibraryManagementApplication.controllers;

import com.example.LibraryManagementApplication.dtos.LibraryDto;
import com.example.LibraryManagementApplication.dtos.LibraryResponseDto;
import com.example.LibraryManagementApplication.services.LibraryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/library")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping(path = "/lend")
    public LibraryResponseDto lendBook(@RequestBody LibraryDto body) {
        this.libraryService.lendBook(body);
        return new LibraryResponseDto("Livro Emprestado");
    }

    @PutMapping(path = "/return/{loanId}")
    public LibraryResponseDto returnBook(@PathVariable Long loanId) {
        this.libraryService.returnBook(loanId);
        return new LibraryResponseDto("Livro Devolvido");
    }
}
