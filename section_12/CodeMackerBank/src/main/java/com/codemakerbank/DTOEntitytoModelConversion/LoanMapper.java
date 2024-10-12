package com.codemakerbank.DTOEntitytoModelConversion;


import com.codemakerbank.DTOModel.LoanDTO;
import com.codemakerbank.models.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LoanMapper {

    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

    Loan loanDTOToLoan(LoanDTO loanDTO);

    List<LoanDTO> loanToLoanDTO(List<Loan> loan);
    LoanDTO loanToLoanDTO(Loan loan);
}
