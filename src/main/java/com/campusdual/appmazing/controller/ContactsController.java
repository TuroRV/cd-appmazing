package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IContactsService;
import com.campusdual.appmazing.model.dto.ContactsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactsController {
    @Autowired
    private IContactsService contactsService;
    @GetMapping
    public String testController(){
        return "Contacts Controller Works";
    }

    @PostMapping(value = "/get")
    public ContactsDTO queryContacts (@RequestBody ContactsDTO contacts){
        return this.contactsService.queryContacts(contacts);
    }
    @GetMapping(value = "/getAll")
    public List<ContactsDTO> queryAllContacts(){
        return this.contactsService.queryAllContacts();
    }
    @PostMapping(value = "/add")
    public int insertContacts(@RequestBody ContactsDTO contacts){
        return this.contactsService.insertContacts(contacts);
    }
    @PutMapping(value = "/update")
    public int updateProduct (@RequestBody ContactsDTO contacts){
        return this.contactsService.updateContacts(contacts);
    }
    @DeleteMapping(value = "/delete")
    public int updateContacts (@RequestBody ContactsDTO contacts){
        return this.contactsService.deleteContacts(contacts);
    }

}
