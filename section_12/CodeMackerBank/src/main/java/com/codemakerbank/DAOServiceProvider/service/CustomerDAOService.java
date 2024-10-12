package com.codemakerbank.DAOServiceProvider.service;

import com.codemakerbank.DTOModel.Contact;
import com.codemakerbank.models.Customer;

public interface CustomerDAOService {
    Customer openNewAccount(Customer customer);
    Contact getContact(String id);
}
