package com.codemakerbank.controller;

import com.codemakerbank.DTOModel.LoanDTO;
import com.codemakerbank.resources.services.LoanService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    // Create a new loan
    @PostMapping
    public ResponseEntity<LoanDTO> createLoan(@RequestBody LoanDTO loanCreateDTO) {
        LoanDTO createdLoan = loanService.saveLoan(loanCreateDTO);
        return new ResponseEntity<>(createdLoan, HttpStatus.CREATED);
    }

    // Get a loan by ID
    @GetMapping("/{loan_Id}")
    public ResponseEntity<LoanDTO> getLoanById(@PathVariable("loan_Id") String id) {
        try {
            LoanDTO loanDTO = loanService.getLoanById(id);
            if (loanDTO != null) {
                return new ResponseEntity<>(loanDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    // Get all loans
    @GetMapping
    public ResponseEntity<List<LoanDTO>> getAllLoans() {
        List<LoanDTO> loanDTOs = loanService.getAllLoans();
        return new ResponseEntity<>(loanDTOs, HttpStatus.OK);
    }

    // Update an existing loan
    @PutMapping("/{loan_Id}")
    public ResponseEntity<LoanDTO> updateLoan(@PathVariable("loan_Id") String id, @RequestBody LoanDTO loanUpdateDTO) {
        LoanDTO updatedLoan = loanService.updateLoan(id, loanUpdateDTO);
        if (updatedLoan != null) {
            return new ResponseEntity<>(updatedLoan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a loan by ID
    @DeleteMapping("/{loan_Id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable("loan_Id") String id) {
        boolean isDeleted = loanService.deleteLoan(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{all}/{customer_Id}")
    public ResponseEntity<List<LoanDTO>> getAllCustomerLoan(@PathVariable("customer_Id") long id)
    {
        try {
            List<LoanDTO> allCustomerLoan = this.loanService.findAllCustomerLoan(id);
            return ResponseEntity.ok(allCustomerLoan);
        }catch (EntityNotFoundException e){
            throw e;
        }
    }
}
