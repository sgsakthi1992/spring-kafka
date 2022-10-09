package com.github.example.springkafka.producer.controller;

import com.github.example.springkafka.common.dto.EmployeeDto;
import com.github.example.springkafka.producer.kafka.EmployeeProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/producer")
public class ProducerController {

    private final EmployeeProducer producer;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody EmployeeDto employeeDto) {
        producer.insert(employeeDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody EmployeeDto employeeDto) {
        producer.delete(employeeDto);
        return ResponseEntity.ok().build();
    }
}
