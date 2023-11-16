package com.uzum.notification.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RabbitConf {

    @Autowired
    private Environment env;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(env.getProperty("env.host"));
        cachingConnectionFactory.setUsername(env.getProperty("env.username"));
        cachingConnectionFactory.setPassword(env.getProperty("env.password"));
        cachingConnectionFactory.setPort(Integer.parseInt(env.getProperty("env.port")));
        return cachingConnectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue myQueue() {
        return new Queue(env.getProperty("env.queue"));
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(env.getProperty("env.exchange"), true, false);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(env.getProperty("env.routingkey"));
    }
}
