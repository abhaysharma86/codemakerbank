package com.codemakerbank.DAOServiceProvider.service;

import com.codemakerbank.models.Customer;

import java.util.UUID;

public interface AccountViewDAOService {
    Customer viewAccount(String accountId);
}
