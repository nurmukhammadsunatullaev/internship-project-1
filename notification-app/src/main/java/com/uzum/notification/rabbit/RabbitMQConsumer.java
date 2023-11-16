package com.uzum.notification.rabbit;

import com.uzum.notification.telegram.Bot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
@Slf4j
public class RabbitMQConsumer {

    @Autowired
    private Environment env;

    private Bot bot;

    private void bot_init() {
        String token = env.getProperty("env.tg.token");
        String botname = env.getProperty("env.tg.botname");
        String chatid = env.getProperty("env.tg.chat-id");
        bot = new Bot(token, botname, chatid);
    }

    @RabbitListener(queues = "uzum-queue1")
    public void processMyQueue(String message) {
        bot_init();
        log.info(message);
        bot.sendToTelegram(message);
    }
}