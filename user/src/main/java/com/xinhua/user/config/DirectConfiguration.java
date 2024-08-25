package com.xinhua.user.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfiguration {


    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange",true,false);
    }


    @Bean
    public Queue directQueue(){
        return new Queue("directQueue",true);
    }



    @Bean
    public Binding directBinding(Queue directQueue, DirectExchange directExchange){
        return BindingBuilder.bind(directQueue).to(directExchange).with("red");
    }
}
