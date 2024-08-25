package com.xinhua.user.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@AllArgsConstructor
@Slf4j
public class MqConfig {

    private final RabbitTemplate rabbitTemplate;


    @PostConstruct
    public void init() {
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback(){

            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                log.error("触发return callback");
                log.error("exchange: {}",returnedMessage.getExchange());
                log.error("replyCode: {}",returnedMessage.getReplyCode());
                log.error("replyText: {}",returnedMessage.getReplyText());
            }
        });
    }
}
