package com.codemakerbank.repository;

import com.codemakerbank.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByAccountNumber(String accountNumber);
    Customer findByCustomerId(String id);
}
