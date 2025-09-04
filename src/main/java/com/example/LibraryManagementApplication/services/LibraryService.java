package com.example.LibraryManagementApplication.services;

import com.example.LibraryManagementApplication.dtos.LibraryDto;
import com.example.LibraryManagementApplication.exceptions.BookAlreadyReturnedException;
import com.example.LibraryManagementApplication.exceptions.ReservationLimitExceededException;
import com.example.LibraryManagementApplication.exceptions.ReservationNotUnavailableException;
import com.example.LibraryManagementApplication.model.Book;
import com.example.LibraryManagementApplication.model.Client;
import com.example.LibraryManagementApplication.model.Loan;
import com.example.LibraryManagementApplication.repositories.BookRepository;
import com.example.LibraryManagementApplication.repositories.ClientRepository;
import com.example.LibraryManagementApplication.repositories.LoanRepository;
import com.example.LibraryManagementApplication.validators.ExistsBookLoanValidator;
import com.example.LibraryManagementApplication.validators.ExistsBookValidator;
import com.example.LibraryManagementApplication.validators.ExistsClientValidator;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    private final ClientRepository clientRepository;
    private final BookRepository bookRepository;
    private final ExistsClientValidator existsClientValidator;
    private final ExistsBookValidator existsBookValidator;
    private final LoanRepository loanRepository;
    private final ExistsBookLoanValidator existsBookLoanValidator;

    public LibraryService(ClientRepository clientRepository, BookRepository bookRepository, ExistsClientValidator existsClientValidator, ExistsBookValidator existsBookValidator, LoanRepository loanRepository, ExistsBookLoanValidator existsBookLoanValidator) {
        this.bookRepository = bookRepository;
        this.clientRepository = clientRepository;
        this.existsClientValidator = existsClientValidator;
        this.existsBookValidator = existsBookValidator;
        this.loanRepository = loanRepository;
        this.existsBookLoanValidator = existsBookLoanValidator;
    }

    @Transactional
    public void lendBook(LibraryDto input) {
        Book book = this.existsBookValidator.validateById(input.getBookId());
        if (!book.getAvailable()) {
            throw new ReservationNotUnavailableException();
        }
        Client client = this.existsClientValidator.validateById(input.getClientId());
        if (client.getQuantityBooks() >= 3) {
            throw new ReservationLimitExceededException();
        }
        book.setAvailable(false);
        this.bookRepository.save(book);
        client.incrementQuantityBooks(1);
        this.clientRepository.save(client);
        Loan loan = new Loan(client, book);
        this.loanRepository.save(loan);
    }

    @Transactional
    public void returnBook(Long loanId) {
        Loan loan = this.existsBookLoanValidator.validateById(loanId);
        Client client = this.existsClientValidator.validateById(loan.getClientId());
        Book book = this.existsBookValidator.validateById(loan.getBookId());
        if (book.getAvailable()) {
            throw new BookAlreadyReturnedException();
        }
        book.setAvailable(true);
        client.decrementQuantityBooks(1);
        this.bookRepository.save(book);
        this.clientRepository.save(client);
        loan.setReturned(true);
        this.loanRepository.save(loan);
    }
}
