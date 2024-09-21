package com.codemakerbank.resources.services;

import com.codemakerbank.DTOModel.LoanDTO;
import com.codemakerbank.models.Loan;
import java.util.List;
import java.util.Optional;

public interface LoanService {
    LoanDTO saveLoan(LoanDTO loan);
    LoanDTO getLoanById(String id);
    List<LoanDTO> getAllLoans();
    LoanDTO updateLoan(String id,LoanDTO loan);
    boolean deleteLoan(String id);
    List<LoanDTO> findAllCustomerLoan(long id);
}
