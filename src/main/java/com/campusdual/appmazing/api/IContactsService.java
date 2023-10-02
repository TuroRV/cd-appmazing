package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.Contacts;
import com.campusdual.appmazing.model.dto.ContactsDTO;
import com.campusdual.appmazing.model.dto.ProductDTO;


import java.util.List;

public interface IContactsService {
    public ContactsDTO queryContacts (ContactsDTO ContactsDTO);
    List<ContactsDTO> queryAllContacts();
    int insertContacts (ContactsDTO contactsDTO);
    int updateContacts(ContactsDTO contactsDTO);
    int deleteContacts(ContactsDTO contactsDTO);

}
