package com.github.example.springkafka.consumer.repository;

import com.github.example.springkafka.consumer.common.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name);

    long deleteByName(String name);
}
