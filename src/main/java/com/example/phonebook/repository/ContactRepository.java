package com.example.phonebook.repository;

import com.example.phonebook.domain.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByNameContaining(String name);
    List<Contact> findByNameOrPhoneContaining(String name, String phone);
}