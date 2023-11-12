package com.uzum.main.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

    private final RabbitMQProducerService rabbitMQProducerService;

    @Autowired
    public RabbitController(RabbitMQProducerService rabbitMQProducerService) {
        this.rabbitMQProducerService = rabbitMQProducerService;
    }

    @GetMapping("/test")
    public String healthCheck() {
        rabbitMQProducerService.sendMessage("MESSAGE", Parameters.ROUTINGKEY);
        return "Message has sent to notification-app";
    }
}