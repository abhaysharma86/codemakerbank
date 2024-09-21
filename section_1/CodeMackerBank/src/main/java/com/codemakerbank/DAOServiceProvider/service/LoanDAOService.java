package com.codemakerbank.DAOServiceProvider.service;

import com.codemakerbank.models.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanDAOService {
    Loan save(Loan loan);
    Loan findById(String id);
    List<Loan> findAll();
    void deleteById(long id);
    Loan updateLoan(String id, Loan loan);
    List<Loan> findAllCustomerLoan(long id);
}
