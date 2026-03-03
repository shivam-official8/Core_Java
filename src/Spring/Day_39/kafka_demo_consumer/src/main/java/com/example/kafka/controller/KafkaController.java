package com.example.kafka.controller;

import com.example.kafka.service.KafkaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private KafkaService kafkaService;

    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @GetMapping("/get-course")
    public ResponseEntity<String> getCourse(){
        String response = kafkaService.getMessage();
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
