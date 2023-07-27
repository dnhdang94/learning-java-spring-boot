package com.dangdnh.service.impl;

import com.dangdnh.model.Student;
import com.dangdnh.service.ConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @RabbitListener(queues = {"${dangdnh.rabbitmq.queue}"})
    public void consumer(Student student) {
        System.out.println(student);
    }
}
