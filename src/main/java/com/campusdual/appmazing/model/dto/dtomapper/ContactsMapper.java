package com.campusdual.appmazing.model.dto.dtomapper;

import com.campusdual.appmazing.model.Contacts;
import com.campusdual.appmazing.model.dto.ContactsDTO;
import com.campusdual.appmazing.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactsMapper {
    ContactsMapper INSTANCE = Mappers.getMapper(ContactsMapper.class);
    ContactsDTO toDTO(Contacts contacts);
    List<ContactsDTO> toDTOList(List<Contacts> contacts);
    Contacts toEntity(ContactsDTO contactsDTO);
}
