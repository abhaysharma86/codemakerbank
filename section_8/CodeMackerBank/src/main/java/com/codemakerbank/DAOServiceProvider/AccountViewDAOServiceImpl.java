package com.codemakerbank.DAOServiceProvider;

import com.codemakerbank.DAOServiceProvider.service.AccountViewDAOService;
import com.codemakerbank.models.Customer;
import com.codemakerbank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AccountViewDAOServiceImpl implements AccountViewDAOService {
    private final CustomerRepository customerRepository;
    @Override
    public Customer viewAccount(String accountId) {
        Customer byAccountNumber = this.customerRepository.findByAccountNumber(accountId);
        return byAccountNumber;
    }
}
