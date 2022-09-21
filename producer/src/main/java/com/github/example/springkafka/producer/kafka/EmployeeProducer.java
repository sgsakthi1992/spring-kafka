package com.github.example.springkafka.producer.kafka;

import com.github.example.springkafka.common.KafkaConfig;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@AllArgsConstructor
public class EmployeeProducer {

    private final KafkaTemplate<String, String> kafka;

    public void insert(String name) {
        var record = new ProducerRecord<>(KafkaConfig.EMPLOYEE_TOPIC, name, name);
        record.headers().add(KafkaConfig.OPERATION, KafkaConfig.INSERT.getBytes());
        var future = kafka.send(record);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                ex.printStackTrace();
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Success");
            }
        });
    }

    public void delete(String name) {
        var record = new ProducerRecord<>(KafkaConfig.EMPLOYEE_TOPIC, name, name);
        record.headers().add(KafkaConfig.OPERATION, KafkaConfig.INSERT.getBytes());
        var future = kafka.send(record);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                ex.printStackTrace();
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Success");
            }
        });
    }
}
