package com.codemakerbank.resources.services;

import com.codemakerbank.DTOModel.AccountViewDTO;
import com.codemakerbank.DTOModel.Contact;

public interface AccountViewService {
    AccountViewDTO viewAccount(String accountNumber);
}
