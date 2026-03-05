package com.example.kafka.service;

import com.example.kafka.model.Course;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private String message;

    @KafkaListener(topics="shivam_v2", groupId="shivam-group")
    public void consumeMessage(Course course){
        message = course + " got the data from kafka";
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }
}
