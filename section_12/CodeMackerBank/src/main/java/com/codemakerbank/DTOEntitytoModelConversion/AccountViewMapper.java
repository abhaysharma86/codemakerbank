package com.codemakerbank.DTOEntitytoModelConversion;


import com.codemakerbank.DTOModel.AccountViewDTO;
import com.codemakerbank.models.AccountView;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountViewMapper {

    AccountViewMapper INSTANCE = Mappers.getMapper(AccountViewMapper.class);

    AccountView AccountViewDTOToAccountView(AccountViewDTO customerDAO);
    AccountViewDTO AccountViewToAccountViewDTO(AccountView customerDAO);
}
