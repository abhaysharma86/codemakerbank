package com.codemakerbank.DTOModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {
    private long id;
    private String loanNumber;
    private double loanAmount;
    private double interestRate;
    private int loanTermMonths; // Duration in months
    private Date startDate;
    private Date endDate;
    private String loanType;
    private String status;
    private long customerId; // Assuming this is the customer identifier

}
