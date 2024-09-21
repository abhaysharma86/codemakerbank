package com.codemakerbank.DTOModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AccountViewDTO implements Serializable {
    private String accountNumber;
    private String accountType;
    private String accountBalanceFormatted;
    private String creationDateFormatted;
    private String status;
}
