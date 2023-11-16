package com.uzum.notification.rabbit;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class RabbitMQConsumer {
    @RabbitListener(queues = "uzum-queue1")
    public void processMyQueue(String message) {
        System.out.println(message);
    }
}