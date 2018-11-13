package com.example.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



/**
 * @program: RabbitMq接收端
 * @description: RabbitMqReceive
 * @author: 梁昊
 * @create: 2018-11-13 14:04
 **/
@Component
public class RabbitConfig {
    @Bean
    public Queue getJiaKaiQueue() {
        return new Queue("JiaKai");
    }
}
