package com.uzum.main.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducerServiceImpl implements RabbitMQProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    private Environment env;

    @Autowired
    public RabbitMQProducerServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message, String routingKey) {
        rabbitTemplate.convertAndSend(env.getProperty("env.exchange"), routingKey, message);
    }
}