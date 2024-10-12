package com.codemakerbank.DTOEntitytoModelConversion;


import com.codemakerbank.DTOModel.CustomerDTO;
import com.codemakerbank.models.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer CustomerDAOToCustomer(CustomerDTO customerDAO);

    CustomerDTO CustomerToCustomerDAO(Customer customer);
}
