package com.example.contactmanagement.controller;

import com.example.contactmanagement.entity.Contact;
import com.example.contactmanagement.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://cooperative-cat-production-6688.up.railway.app"
})
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping
    public Contact saveContact(@RequestBody Contact contact) {
        return service.saveContact(contact);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return service.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getContact(@PathVariable int id) {
        return service.getContactById(id);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable int id,
                                 @RequestBody Contact contact) {
        return service.updateContact(id, contact);
    }

    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable int id) {
        return service.deleteContact(id);
    }
}