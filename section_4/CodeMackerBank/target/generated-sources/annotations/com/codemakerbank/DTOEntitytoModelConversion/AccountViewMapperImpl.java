package com.codemakerbank.DTOEntitytoModelConversion;

import com.codemakerbank.DTOModel.AccountViewDTO;
import com.codemakerbank.models.AccountView;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-15T21:29:54+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
public class AccountViewMapperImpl implements AccountViewMapper {

    @Override
    public AccountView AccountViewDTOToAccountView(AccountViewDTO customerDAO) {
        if ( customerDAO == null ) {
            return null;
        }

        AccountView accountView = new AccountView();

        accountView.setAccountNumber( customerDAO.getAccountNumber() );
        accountView.setAccountType( customerDAO.getAccountType() );
        accountView.setAccountBalanceFormatted( customerDAO.getAccountBalanceFormatted() );
        accountView.setCreationDateFormatted( customerDAO.getCreationDateFormatted() );
        accountView.setStatus( customerDAO.getStatus() );

        return accountView;
    }

    @Override
    public AccountViewDTO AccountViewToAccountViewDTO(AccountView customerDAO) {
        if ( customerDAO == null ) {
            return null;
        }

        AccountViewDTO accountViewDTO = new AccountViewDTO();

        accountViewDTO.setAccountNumber( customerDAO.getAccountNumber() );
        accountViewDTO.setAccountType( customerDAO.getAccountType() );
        accountViewDTO.setAccountBalanceFormatted( customerDAO.getAccountBalanceFormatted() );
        accountViewDTO.setCreationDateFormatted( customerDAO.getCreationDateFormatted() );
        accountViewDTO.setStatus( customerDAO.getStatus() );

        return accountViewDTO;
    }
}
