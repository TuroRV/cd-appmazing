package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IContactsService;
import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.Contacts;
import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dao.ContactsDao;
import com.campusdual.appmazing.model.dao.ProductDao;
import com.campusdual.appmazing.model.dto.ContactsDTO;
import com.campusdual.appmazing.model.dto.ProductDTO;
import com.campusdual.appmazing.model.dto.dtomapper.ContactsMapper;
import com.campusdual.appmazing.model.dto.dtomapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ContactsService")
@Lazy
public class ContactsService implements IContactsService {

    @Autowired
    private ContactsDao contactsDao;
    @Autowired
    private IProductService productService;
    @Autowired
    private ProductDao productDao;


    @Override
    public ContactsDTO queryContacts(ContactsDTO ContactsDTO) {
        Contacts contacs = ContactsMapper.INSTANCE.toEntity(ContactsDTO);
        Contacts contactsFinal = this.contactsDao.getReferenceById(contacs.getId());
        ContactsDTO dto = ContactsMapper.INSTANCE.toDTO(contactsFinal);
        return dto;
    }

    @Override
    public List<ContactsDTO> queryAllContacts() {
        return ContactsMapper.INSTANCE.toDTOList(this.contactsDao.findAll());
    }

    @Override
    public int insertContacts(ContactsDTO contactsDTO) {
        Contacts contacts = ContactsMapper.INSTANCE.toEntity(contactsDTO);
        this.contactsDao.saveAndFlush(contacts);
        return contacts.getId();
    }

    @Override
    public int updateContacts(ContactsDTO contactsDTO) {
        return this.insertContacts(contactsDTO);
    }

    @Override
    public int deleteContacts(ContactsDTO contactsDTO) {
        int id = contactsDTO.getId();
        Contacts contacts = ContactsMapper.INSTANCE.toEntity(contactsDTO);
        this.contactsDao.delete(contacts);
        return id;
    }

    }

