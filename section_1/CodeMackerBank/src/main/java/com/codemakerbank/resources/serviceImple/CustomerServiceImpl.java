package com.codemakerbank.resources.serviceImple;

import com.codemakerbank.DTOModel.Contact;
import com.codemakerbank.DTOModel.CustomerDTO;
import com.codemakerbank.DAOServiceProvider.service.CustomerDAOService;
import com.codemakerbank.DTOEntitytoModelConversion.CustomerMapper;
import com.codemakerbank.models.Customer;
import com.codemakerbank.resources.services.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAOService customerDAOService;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    @Override
    public CustomerDTO openNewAccount(CustomerDTO customerDTO) {
        customerDTO.setCustomerId(generateAccountNumber(10));
        customerDTO.setAccountNumber(generateAccountNumber(10));
        Customer customer1 = this.customerMapper.CustomerDAOToCustomer(customerDTO);
        customer1.setId(generateLongID());
        Customer customer2 = this.customerDAOService.openNewAccount(customer1);
        return this.customerMapper.CustomerToCustomerDAO(customer2);
    }

    @Override
    public Contact getContact(String id) {
        try {
           return this.customerDAOService.getContact(id);
        }catch (EntityNotFoundException e){
            throw e;
        }
    }

    public static UUID generateUUID() {
        return UUID.randomUUID();
    }
    public static String generateAccountNumber(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        Random random = new Random();
        int min = (int) Math.pow(10, length - 1);
        int max = (int) Math.pow(10, length) - 1;
        int number = random.nextInt(max - min + 1) + min;
        return String.format("%0" + length + "d", number);
    }
    public static long generateLongID() {
        Random random = new Random();
        return (long) (random.nextDouble() * 1_000_000_000_000_000L);
    }
}
