package com.codemakerbank.DTOEntitytoModelConversion;

import com.codemakerbank.DTOModel.LoanDTO;
import com.codemakerbank.models.Loan;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-15T21:54:33+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
public class LoanMapperImpl implements LoanMapper {

    @Override
    public Loan loanDTOToLoan(LoanDTO loanDTO) {
        if ( loanDTO == null ) {
            return null;
        }

        Loan loan = new Loan();

        loan.setId( loanDTO.getId() );
        loan.setLoanNumber( loanDTO.getLoanNumber() );
        loan.setLoanAmount( loanDTO.getLoanAmount() );
        loan.setInterestRate( loanDTO.getInterestRate() );
        loan.setLoanTermMonths( loanDTO.getLoanTermMonths() );
        loan.setStartDate( loanDTO.getStartDate() );
        loan.setEndDate( loanDTO.getEndDate() );
        loan.setLoanType( loanDTO.getLoanType() );
        loan.setStatus( loanDTO.getStatus() );
        loan.setCustomerId( loanDTO.getCustomerId() );

        return loan;
    }

    @Override
    public List<LoanDTO> loanToLoanDTO(List<Loan> loan) {
        if ( loan == null ) {
            return null;
        }

        List<LoanDTO> list = new ArrayList<LoanDTO>( loan.size() );
        for ( Loan loan1 : loan ) {
            list.add( loanToLoanDTO( loan1 ) );
        }

        return list;
    }

    @Override
    public LoanDTO loanToLoanDTO(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanDTO loanDTO = new LoanDTO();

        loanDTO.setId( loan.getId() );
        loanDTO.setLoanNumber( loan.getLoanNumber() );
        loanDTO.setLoanAmount( loan.getLoanAmount() );
        loanDTO.setInterestRate( loan.getInterestRate() );
        loanDTO.setLoanTermMonths( loan.getLoanTermMonths() );
        loanDTO.setStartDate( loan.getStartDate() );
        loanDTO.setEndDate( loan.getEndDate() );
        loanDTO.setLoanType( loan.getLoanType() );
        loanDTO.setStatus( loan.getStatus() );
        loanDTO.setCustomerId( loan.getCustomerId() );

        return loanDTO;
    }
}
