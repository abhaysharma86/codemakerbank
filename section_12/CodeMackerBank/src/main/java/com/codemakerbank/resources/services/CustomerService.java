package com.codemakerbank.resources.services;

import com.codemakerbank.DTOModel.Contact;
import com.codemakerbank.DTOModel.CustomerDTO;

public interface CustomerService {

    CustomerDTO openNewAccount(CustomerDTO customer);
    Contact getContact(String id);

}
