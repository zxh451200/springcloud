package com.xinhua.gateway.filters;

import lombok.Data;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class PrintAnyGatewayFilterFactory extends AbstractGatewayFilterFactory<PrintAnyGatewayFilterFactory.Config> {


    @Override
    public GatewayFilter apply(Config config) {
//        return new GatewayFilter() {
//            @Override
//            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//                System.out.println("PrintAnyGateWayFilterFactory");
//                return chain.filter(exchange);
//            }
//        };

        //带优先级
        return new OrderedGatewayFilter((exchange, chain) -> {
            String address = config.getAddress();
            String age = config.getAge();
            String name = config.getName();
            System.out.println("姓名:"+name+"\n年龄:"+age+"\n地址:"+address);
            System.out.println("PrintAnyGateWayFilterFactory");
            return chain.filter(exchange);
        }, 1);
    }

    //配置类
    @Data
    public static class Config {
        private String name;
        private String address;
        private String age;
    }

    // 决定了读取参数的顺序，默认是按照类中声明的顺序
    @Override
    public List<String> shortcutFieldOrder() {
        return List.of("name", "age", "address");
    }

    public PrintAnyGatewayFilterFactory() {
        super(Config.class);
    }
}
