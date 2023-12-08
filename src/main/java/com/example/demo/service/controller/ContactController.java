package com.example.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Contact; 
import com.example.demo.service.interfaces.IContact; 

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    IContact contactService; 

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    Contact save(@RequestBody Contact contact) { 
        System.out.println("*******save ***********");
        Contact c = contactService.saveContact(contact); 
        System.out.println("*******" + c.getEmail());
        return c;
    }

    @GetMapping("/{id}")
    Contact getContactById(@PathVariable Long id) {
        return contactService.getContact(id); 
    }

    @GetMapping("/quantity")
    int getQuantityContact() { 
        return contactService.getQuantityOfContact(); 
    }

    @GetMapping("/contactByName/{name}") 
    Contact getContactByName(@PathVariable String name) { 
        return contactService.findContactByName(name); 
    }

    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
        contactService.deleteContact(id); 
        return true;
    }
}
