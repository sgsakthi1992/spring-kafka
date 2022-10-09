package com.github.example.springkafka.common.dto;

import java.time.LocalDate;

public record EmployeeDto(String name, LocalDate dob) {
}
