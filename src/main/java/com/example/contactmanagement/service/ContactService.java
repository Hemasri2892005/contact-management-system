package com.example.contactmanagement.service;

import com.example.contactmanagement.entity.Contact;
import com.example.contactmanagement.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    public Contact saveContact(Contact contact) {
        return repository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public Contact getContactById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Contact updateContact(int id, Contact newContact) {

        Contact contact = repository.findById(id).orElse(null);

        if (contact != null) {

            contact.setName(newContact.getName());
            contact.setPhone(newContact.getPhone());
            contact.setEmail(newContact.getEmail());
            contact.setAddress(newContact.getAddress());

            return repository.save(contact);
        }

        return null;
    }

    public String deleteContact(int id) {

        repository.deleteById(id);

        return "Contact Deleted Successfully";
    }

}