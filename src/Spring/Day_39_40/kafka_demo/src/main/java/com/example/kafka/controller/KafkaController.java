package com.example.kafka.controller;

import com.example.kafka.model.Course;
import com.example.kafka.service.KafkaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private KafkaService kafkaService;

    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("/add-course")
    public ResponseEntity<String> addCourse(@RequestBody Course course){
        System.out.println("hello");
        String response = kafkaService.sendMessage(course);
        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }
}
