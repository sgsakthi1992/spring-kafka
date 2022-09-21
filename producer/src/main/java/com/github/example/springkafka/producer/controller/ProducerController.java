package com.github.example.springkafka.producer.controller;

import com.github.example.springkafka.producer.kafka.EmployeeProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/producer")
public class ProducerController {

    private final EmployeeProducer producer;

    @PostMapping("{name}")
    public ResponseEntity<String> insert(@PathVariable String name) {
        producer.insert(name);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{name}")
    public ResponseEntity<String> delete(@PathVariable String name) {
        producer.delete(name);
        return ResponseEntity.ok().build();
    }
}
