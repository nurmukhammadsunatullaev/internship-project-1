package com.uzum.notification.rabbit;

import com.uzum.notification.telegram.Bot;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class RabbitMQConsumer {

    private final Bot bot = new Bot();

    @RabbitListener(queues = "uzum-queue1")
    public void processMyQueue(String message) {
        System.out.println(message);
        bot.sendToTelegram(message);
    }
}