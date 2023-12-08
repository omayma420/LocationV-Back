package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.persistance.entities.Contact;

public interface IContact {
	
	Contact saveContact(Contact contact); 
    Contact updateContact(Contact contact);
    boolean deleteContact(Long id); 
    List<Contact> getListContact(); 
    Contact getContact(Long id); 
    Contact findContactByName(String name); 
    int getQuantityOfContact(); 
    Contact getContactByIdContact(Long id);

}
