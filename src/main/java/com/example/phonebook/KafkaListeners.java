package com.example.phonebook;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "contact", groupId = "groupId")
    void Listener(String data){
        System.out.print("Listener received: " + data + " :) ");
    }
}
