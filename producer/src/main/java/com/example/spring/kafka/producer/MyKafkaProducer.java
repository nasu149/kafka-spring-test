package com.example.spring.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MyKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(@NonNull String key, @NonNull String message) {
        // 第1引数: トピック名
        // 第2引数: パーティションキー (これによって保存先パーティションが決まる)
        // 第3引数: メッセージ本体
        kafkaTemplate.send("my-topic", key, message);
    }
}