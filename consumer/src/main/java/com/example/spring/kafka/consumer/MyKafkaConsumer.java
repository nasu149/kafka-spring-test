package com.example.spring.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaConsumer {

    // topics には購読したいトピック名を指定します
    @KafkaListener(topics = "my-topic", groupId = "my-consumer-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}