package com.codemakerbank.DAOServiceProvider;

import com.codemakerbank.DAOServiceProvider.service.CustomerDAOService;
import com.codemakerbank.DTOModel.Contact;
import com.codemakerbank.models.Customer;
import com.codemakerbank.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDAOServiceImpl implements CustomerDAOService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer openNewAccount(Customer customer) {
        Customer save = this.customerRepository.save(customer);
        return save;
    }

    @Override
    public Contact getContact(String id) {
        Customer byCustomerId = this.customerRepository.findByCustomerId(id);
        if(byCustomerId == null){
            throw new EntityNotFoundException("User Not found with id: "+id);
        }
        Contact contact=new Contact(byCustomerId.getFirstName(),byCustomerId.getLastName(),byCustomerId.getEmailAddress(),byCustomerId.getPhoneNumber());

        return contact;
    }
}
