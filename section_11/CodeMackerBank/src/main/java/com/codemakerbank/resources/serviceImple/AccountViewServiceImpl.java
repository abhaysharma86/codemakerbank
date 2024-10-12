package com.codemakerbank.resources.serviceImple;

import com.codemakerbank.DAOServiceProvider.service.AccountViewDAOService;
import com.codemakerbank.DTOEntitytoModelConversion.AccountViewMapper;
import com.codemakerbank.DTOModel.AccountViewDTO;
import com.codemakerbank.DTOModel.Contact;
import com.codemakerbank.models.AccountView;
import com.codemakerbank.models.Customer;
import com.codemakerbank.resources.services.AccountViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccountViewServiceImpl implements AccountViewService {
    private final AccountViewDAOService accountViewDAOService;
    private final AccountViewMapper accountViewMapper = AccountViewMapper.INSTANCE;
    @Override
    public AccountViewDTO viewAccount(String accountNumber) {
        Customer customer = this.accountViewDAOService.viewAccount(accountNumber);
        AccountView accountView = new AccountView();
        accountView.setAccountType(customer.getAccountType());
        accountView.setAccountNumber(customer.getAccountNumber());
        accountView.setStatus(customer.getStatus());
        accountView.setCreationDateFormatted(customer.getCreationDate().toString());
        AccountViewDTO accountViewDTO = this.accountViewMapper.AccountViewToAccountViewDTO(accountView);
        return accountViewDTO;
    }
}
