package com.codemakerbank.DAOServiceProvider;

import com.codemakerbank.DAOServiceProvider.service.LoanDAOService;
import com.codemakerbank.models.Loan;
import com.codemakerbank.repository.LoanRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@RequiredArgsConstructor
@Component
public class LoanDAOImpl implements LoanDAOService {

    private final LoanRepository loanRepository;

    @Override
    public Loan save(Loan loan) {
        return this.loanRepository.save(loan);
    }

    @Override
    public Loan findById(String id) {

        Loan byLoanNumber = this.loanRepository.findByLoanNumber(id);
        if(byLoanNumber == null){
            throw new EntityNotFoundException("Loan Not Found with id: "+id);
        }
        return byLoanNumber;
    }

    @Override
    public List<Loan> findAll() {
        return this.loanRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        this.loanRepository.deleteById(id);
    }

    @Override
    public Loan updateLoan(String id, Loan loan) {
        Loan byLoanNumber = this.loanRepository.findByLoanNumber(id);
        if(byLoanNumber == null){
            throw new EntityNotFoundException("User not found with id: "+id);
        }
        byLoanNumber.setLoanAmount(loan.getLoanAmount());
        byLoanNumber.setLoanType(loan.getLoanType());
        byLoanNumber.setLoanTermMonths(loan.getLoanTermMonths());
        byLoanNumber.setInterestRate(loan.getInterestRate());
        byLoanNumber.setStatus(loan.getStatus());
        return this.loanRepository.save(byLoanNumber);
    }

    @Override
    public List<Loan> findAllCustomerLoan(long id) {
        List<Loan> byCustomerId = this.loanRepository.findByCustomerId(id);
        if(byCustomerId == null){
            throw new EntityNotFoundException("Customer Not found with id : "+id);
        }
        return byCustomerId;
    }
}
