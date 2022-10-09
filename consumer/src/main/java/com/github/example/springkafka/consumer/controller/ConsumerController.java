package com.github.example.springkafka.consumer.controller;

import com.github.example.springkafka.consumer.model.Employee;
import com.github.example.springkafka.consumer.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/consumer")
public class ConsumerController {
    private final EmployeeService service;

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }
}
