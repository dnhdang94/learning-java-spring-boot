package com.dangdnh.service.impl;

import com.dangdnh.config.RabbitMQConfig;
import com.dangdnh.model.Student;
import com.dangdnh.service.ProducerService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

    private final RabbitMQConfig config;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ProducerServiceImpl(RabbitMQConfig config,
                               RabbitTemplate rabbitTemplate) {
        this.config = config;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void send(Student student) {
        rabbitTemplate.convertAndSend(config.getExchange(), config.getRoutingkey(), student);
    }
}
