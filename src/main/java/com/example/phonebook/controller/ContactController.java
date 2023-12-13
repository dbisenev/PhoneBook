package com.example.phonebook.controller;

import com.example.phonebook.domain.Contact;
import com.example.phonebook.repository.ContactRepository;
import com.example.phonebook.service.ContactService;
import org.apache.kafka.common.network.Mode;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactService contactService;

    @GetMapping("/index")
    public String contact(Model model){
        Iterable<Contact> contacts = contactRepository.findAll();
        model.addAttribute("contacts", contacts);
        return "index";
    }


    @GetMapping("/contact/add")
    public String contactAdd(Model model){
        return "addPhone";
    }
    @PostMapping("/contact/add")
    public String phoneAdd(@RequestParam String name, @RequestParam String phone,Model model){
        Contact contact = new Contact(name, phone);
        contactRepository.save(contact);
        return "redirect:/index";
    }
    @GetMapping("/finder")
    public String showFinder(Model model){
        return "contactFinder";
    }

    @PostMapping("/contact/finder")
    public String found(@RequestParam(name = "name") String name,Model model){
        Iterable<Contact> contacts = contactService.findByNameOrPhone(name);
        model.addAttribute("contacts", contacts);
        return "phoneDetails";
    }
}
