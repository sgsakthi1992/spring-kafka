package com.github.example.springkafka.consumer.service;

import com.github.example.springkafka.consumer.common.Employee;
import com.github.example.springkafka.consumer.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public void insert(String name) {
        var employee = new Employee();
        employee.setName(name);
        employeeRepository.save(employee);
    }

    public void delete(String name) {
        employeeRepository.deleteByName(name);
    }
}
