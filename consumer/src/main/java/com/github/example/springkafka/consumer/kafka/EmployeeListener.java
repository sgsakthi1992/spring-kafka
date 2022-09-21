package com.github.example.springkafka.consumer.kafka;

import com.github.example.springkafka.common.KafkaConfig;
import com.github.example.springkafka.consumer.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmployeeListener {
    private final EmployeeService service;

    @KafkaListener(topics = KafkaConfig.EMPLOYEE_TOPIC)
    public void listen(@Payload String name,
                       @Header(KafkaConfig.OPERATION) String operation) {
        switch (operation) {
            case KafkaConfig.INSERT  -> service.insert(name);
            case KafkaConfig.DELETE -> service.delete(name);
            default -> throw new RuntimeException("Not a valid operation");
        }
    }
}
