package com.xinhua.user;

import api.config.FeignClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("com.xinhua.user.mapper")
@SpringBootApplication
@EnableFeignClients(basePackages = "api.client",defaultConfiguration = FeignClientConfig.class)
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Bean
    @LoadBalanced// 注册中心,如果在main中打开了LoadBalanced,注解这里就要用域名,否则用ip
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
