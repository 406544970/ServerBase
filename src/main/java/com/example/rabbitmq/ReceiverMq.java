package com.example.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: Hello
 * @description: 接收Mq实体类
 * @author: Luan ZhiFei
 * @create: 2018-11-13 14:12
 **/
@Component
@RabbitListener(queues = "JiaKai")
public class ReceiverMq {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver from JiaKai : " + hello);
    }
}
