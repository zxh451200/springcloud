package com.xinhua.user.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfiguration {


    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange",true,false);
    }


    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange",true,false);
    }


    @Bean
    public Queue fanoutQueue(){
//        return QueueBuilder.durable("fanoutQueue").build();
        return new Queue("fanoutQueue",true);
    }



    @Bean
    public Binding fanoutBinding(Queue fanoutQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }
}
