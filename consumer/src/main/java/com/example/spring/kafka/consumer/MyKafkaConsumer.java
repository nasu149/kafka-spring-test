package com.example.spring.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-consumer-group")
    public void consume(ConsumerRecord<String, String> record) {
        // 全ての情報が record オブジェクトに集約されています
        String key = record.key();
        String value = record.value();
        int partition = record.partition();
        long offset = record.offset();

        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("Key: %s, Value: %s (Partition: %d, Offset: %d)%n", 
                          key, value, partition, offset);
    }
}