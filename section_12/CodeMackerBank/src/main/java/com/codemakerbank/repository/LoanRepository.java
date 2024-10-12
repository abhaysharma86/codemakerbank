package com.codemakerbank.repository;

import com.codemakerbank.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Loan findByLoanNumber(String lNo);
    List<Loan> findByCustomerId(long id);
}
