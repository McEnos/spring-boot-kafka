package com.example.kafkapublisher.controllers;

import com.example.kafkapublisher.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

    @Autowired
    private KafkaTemplate<String, User> template;

   /* @GetMapping("/publish/{name}")
    public String publishMessage(@PathVariable("name") String name) {
        template.send("kafka-spring", "Hi " + name + " Welcome to Java Kafka");
        return "Data published";
    }*/

    @GetMapping("/user")
    public String publishUser() {
        User user = new User(2, "Joshua Enos", "PO BOX Nairobi");
        template.send("kafka-new", user);
        return "User published";
    }
}
