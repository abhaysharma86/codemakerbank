package com.codemakerbank.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    @Id
    private long id;
    private String accountNumber;
    private String accountType;
    private String customerId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String nationality;
    private String emailAddress;
    private String phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String stateProvince;
    private String postalCode;
    private String country;
    private String identificationType;
    private String identificationNumber;
    private String accountCurrency;
    private double accountBalance;
    private double overdraftLimit;
    private Date creationDate;
    private String createdBy;
    private String status;
}
