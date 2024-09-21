package com.codemakerbank.DTOEntitytoModelConversion;

import com.codemakerbank.DTOModel.CustomerDTO;
import com.codemakerbank.models.Customer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-15T21:29:54+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer CustomerDAOToCustomer(CustomerDTO customerDAO) {
        if ( customerDAO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setAccountNumber( customerDAO.getAccountNumber() );
        customer.setAccountType( customerDAO.getAccountType() );
        customer.setCustomerId( customerDAO.getCustomerId() );
        customer.setFirstName( customerDAO.getFirstName() );
        customer.setLastName( customerDAO.getLastName() );
        customer.setDateOfBirth( customerDAO.getDateOfBirth() );
        customer.setGender( customerDAO.getGender() );
        customer.setNationality( customerDAO.getNationality() );
        customer.setEmailAddress( customerDAO.getEmailAddress() );
        customer.setPhoneNumber( customerDAO.getPhoneNumber() );
        customer.setAddressLine1( customerDAO.getAddressLine1() );
        customer.setAddressLine2( customerDAO.getAddressLine2() );
        customer.setCity( customerDAO.getCity() );
        customer.setStateProvince( customerDAO.getStateProvince() );
        customer.setPostalCode( customerDAO.getPostalCode() );
        customer.setCountry( customerDAO.getCountry() );
        customer.setIdentificationType( customerDAO.getIdentificationType() );
        customer.setIdentificationNumber( customerDAO.getIdentificationNumber() );
        customer.setAccountCurrency( customerDAO.getAccountCurrency() );
        customer.setAccountBalance( customerDAO.getAccountBalance() );
        customer.setOverdraftLimit( customerDAO.getOverdraftLimit() );
        customer.setCreationDate( customerDAO.getCreationDate() );
        customer.setCreatedBy( customerDAO.getCreatedBy() );
        customer.setStatus( customerDAO.getStatus() );

        return customer;
    }

    @Override
    public CustomerDTO CustomerToCustomerDAO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setAccountNumber( customer.getAccountNumber() );
        customerDTO.setAccountType( customer.getAccountType() );
        customerDTO.setCustomerId( customer.getCustomerId() );
        customerDTO.setFirstName( customer.getFirstName() );
        customerDTO.setLastName( customer.getLastName() );
        customerDTO.setDateOfBirth( customer.getDateOfBirth() );
        customerDTO.setGender( customer.getGender() );
        customerDTO.setNationality( customer.getNationality() );
        customerDTO.setEmailAddress( customer.getEmailAddress() );
        customerDTO.setPhoneNumber( customer.getPhoneNumber() );
        customerDTO.setAddressLine1( customer.getAddressLine1() );
        customerDTO.setAddressLine2( customer.getAddressLine2() );
        customerDTO.setCity( customer.getCity() );
        customerDTO.setStateProvince( customer.getStateProvince() );
        customerDTO.setPostalCode( customer.getPostalCode() );
        customerDTO.setCountry( customer.getCountry() );
        customerDTO.setIdentificationType( customer.getIdentificationType() );
        customerDTO.setIdentificationNumber( customer.getIdentificationNumber() );
        customerDTO.setAccountCurrency( customer.getAccountCurrency() );
        customerDTO.setAccountBalance( customer.getAccountBalance() );
        customerDTO.setOverdraftLimit( customer.getOverdraftLimit() );
        customerDTO.setCreationDate( customer.getCreationDate() );
        customerDTO.setCreatedBy( customer.getCreatedBy() );
        customerDTO.setStatus( customer.getStatus() );

        return customerDTO;
    }
}
