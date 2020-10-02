package com.example.kafkaconsumer.listener;

import com.example.kafkaconsumer.models.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "kafka_new", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed Message: " + message);
    }

    @KafkaListener(topics = "kafka-json1", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("User Message Consumed: " + user);
    }

}
