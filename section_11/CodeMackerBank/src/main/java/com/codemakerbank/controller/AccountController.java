package com.codemakerbank.controller;

import com.codemakerbank.DTOModel.AccountViewDTO;
import com.codemakerbank.DTOModel.Contact;
import com.codemakerbank.DTOModel.CustomerDTO;
import com.codemakerbank.resources.services.AccountViewService;
import com.codemakerbank.resources.services.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Account")
@RequiredArgsConstructor
public class AccountController {

    private final CustomerService customerService;
    private final AccountViewService accountViewService;

    @PostMapping("/open")
    public ResponseEntity<String> newAccount(@RequestBody CustomerDTO customer)
    {
        CustomerDTO customerDTO = this.customerService.openNewAccount(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Welcome : "+customerDTO.getLastName()+", your Account is created successfully.");
    }

    @GetMapping("/contact/{customerId}")
    public ResponseEntity<Object> getContact(@PathVariable("customerId") String id)
    {
        try {
            Contact contact = this.customerService.getContact(id);
            return ResponseEntity.ok(contact);
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/view/{accountNo}")
    public ResponseEntity<AccountViewDTO> viewAccount(@PathVariable("accountNo") String accountNo)
    {
        AccountViewDTO accountViewDTO = this.accountViewService.viewAccount(accountNo);
        return ResponseEntity.ok(accountViewDTO);
    }
}
