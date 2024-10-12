package com.codemakerbank.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loan implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String loanNumber;
    private double loanAmount;
    private double interestRate;
    private int loanTermMonths;  // Number of months for the loan term
    private Date startDate;
    private Date endDate;
    private String loanType;
    private String status;  // e.g., Active, Closed, Defaulted
    
    private long customerId;  // Assuming this is a foreign key to the Customer entity


    // @ManyToOne
    // @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    // private Customer customer;
}
