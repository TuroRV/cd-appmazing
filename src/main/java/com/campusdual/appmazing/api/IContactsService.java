package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.Contacts;
import com.campusdual.appmazing.model.dto.ContactsDTO;


import java.util.List;

public interface IContactsService {
    public ContactsDTO queryContacts (ContactsDTO Contacts);
    List<ContactsDTO> queryAllContacts();
    int insertContacts (ContactsDTO contacts);
    int updateContacts(ContactsDTO contacts);
    int deleteContacts(ContactsDTO contacts);
}
