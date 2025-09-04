package com.example.LibraryManagementApplication.repositories;

import com.example.LibraryManagementApplication.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
