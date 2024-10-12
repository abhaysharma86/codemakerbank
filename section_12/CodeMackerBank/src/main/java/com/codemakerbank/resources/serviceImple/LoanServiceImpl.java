package com.codemakerbank.resources.serviceImple;

import com.codemakerbank.DAOServiceProvider.service.LoanDAOService;
import com.codemakerbank.DTOEntitytoModelConversion.LoanMapper;
import com.codemakerbank.DTOModel.LoanDTO;
import com.codemakerbank.models.Loan;
import com.codemakerbank.resources.services.LoanService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanDAOService loanDAOService;
    private final LoanMapper loanMapper = LoanMapper.INSTANCE.INSTANCE;


    @Override
    public LoanDTO saveLoan(LoanDTO loan) {
        loan.setLoanNumber(CustomerServiceImpl.generateAccountNumber(10));
        Loan loan1 = loanMapper.loanDTOToLoan(loan);
        Loan save = this.loanDAOService.save(loan1);
        LoanDTO loanDTO = this.loanMapper.loanToLoanDTO(save);
        return loanDTO;
    }

    @Override
    public LoanDTO getLoanById(String id) {
        try {
            Loan byId = this.loanDAOService.findById(id);
            LoanDTO loanDTO = this.loanMapper.loanToLoanDTO(byId);
            return loanDTO;
        }catch (EntityNotFoundException e){
            throw e;
        }
    }

    @Override
    public List<LoanDTO> getAllLoans() {
        List<Loan> all = this.loanDAOService.findAll();
        List<LoanDTO> loanDTOS = this.loanMapper.loanToLoanDTO(loanDAOService.findAll());
        return loanDTOS;
    }

    @Override
    public LoanDTO updateLoan(String id,LoanDTO loan) {
        Loan loan1 = this.loanDAOService.updateLoan(id, this.loanMapper.loanDTOToLoan(loan));
        return this.loanMapper.loanToLoanDTO(loan1);
    }

    @Override
    public boolean deleteLoan(String id) {
        try {
            Loan loan = loanDAOService.findById(id); // Assuming id is the loan number
            if (loan != null) {
                this.loanDAOService.deleteById(loan.getId());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<LoanDTO> findAllCustomerLoan(long id) {
        List<Loan> allCustomerLoan = this.loanDAOService.findAllCustomerLoan(id);
        if(allCustomerLoan == null){
            throw new EntityNotFoundException("Customer Not found with id : "+id);
        }
        return this.loanMapper.loanToLoanDTO(allCustomerLoan);
    }
}
