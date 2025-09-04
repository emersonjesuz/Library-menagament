package com.example.LibraryManagementApplication.validators;

import com.example.LibraryManagementApplication.exceptions.ReservationNotFoundException;
import com.example.LibraryManagementApplication.model.Loan;
import com.example.LibraryManagementApplication.repositories.LoanRepository;
import org.springframework.stereotype.Component;

@Component
public class ExistsBookLoanValidator {
    private final LoanRepository loanRepository;

    public ExistsBookLoanValidator(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan validateById(Long loanId) {
        return this.loanRepository.findById(loanId).orElseThrow(ReservationNotFoundException::new);
    }
}
