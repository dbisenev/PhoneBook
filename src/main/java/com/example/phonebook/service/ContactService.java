package com.example.phonebook.service;

import com.example.phonebook.domain.Contact;
import com.example.phonebook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> searchContactsByName(String name){
        return contactRepository.findByNameContaining(name);
    }

    public List<Contact> findByNameOrPhone(String query){
        return contactRepository.findByNameOrPhoneContaining(query, query);
    }

}
