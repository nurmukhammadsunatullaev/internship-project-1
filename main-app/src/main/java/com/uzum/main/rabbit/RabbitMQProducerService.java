package com.uzum.main.rabbit;

public interface RabbitMQProducerService {
    void sendMessage(String message, String routingKey);
}
