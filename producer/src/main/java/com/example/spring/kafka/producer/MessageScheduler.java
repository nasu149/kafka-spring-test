package com.example.spring.kafka.producer;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@EnableScheduling // スケジューリング機能を有効化
public class MessageScheduler {

    private final MyKafkaProducer producer;

    public MessageScheduler(MyKafkaProducer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedRate = 1000) // 1000ms（1秒）ごとに実行
    public void scheduleFixedRateTask() {
        String key = "user-id-" + (int)(Math.random() * 5); // 0~4のキーをランダムに生成
        String message = "Hello Kafka! ID: " + UUID.randomUUID().toString();
        
        System.out.println("Sending message with key: " + key);
        producer.sendMessage(key, message);
    }
}