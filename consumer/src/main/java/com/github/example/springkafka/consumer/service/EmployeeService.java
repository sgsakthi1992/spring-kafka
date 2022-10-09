package com.github.example.springkafka.consumer.service;

import com.github.example.springkafka.common.dto.EmployeeDto;
import com.github.example.springkafka.consumer.model.Employee;
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

    public void insert(EmployeeDto employeeDto) {
        var employee = new Employee();
        employee.setName(employeeDto.name());
        employee.setDob(employeeDto.dob());
        employeeRepository.save(employee);
    }

    public void delete(EmployeeDto employeeDto) {
        employeeRepository.deleteByName(employeeDto.name());
    }
}
