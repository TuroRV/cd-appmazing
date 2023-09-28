package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactsController {
    @Autowired
    private IContactsService contactsService;
    @GetMapping
    public String testController(){
        return "Contacts Controller Works";
    }

}
