package com.xinhua.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Consumer;

//路由过滤器,作用于任意指定的路由,默认不生效配置到理由生效
@Component
public class MyGatewayFilter extends AbstractGatewayFilterFactory {

    @Override
    public GatewayFilter apply(String routeId, Consumer consumer) {
        return super.apply(routeId, consumer);
    }

    @Override
    public GatewayFilter apply(Consumer consumer) {
        return super.apply(consumer);
    }

    @Override
    public GatewayFilter apply(Object config) {
        return null;
    }

    @Override
    public GatewayFilter apply(String routeId, Object config) {
        return super.apply(routeId, config);
    }

    @Override
    public String name() {
        return super.name();
    }

    @Override
    public ShortcutType shortcutType() {
        return super.shortcutType();
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return super.shortcutFieldOrder();
    }

    @Override
    public String shortcutFieldPrefix() {
        return super.shortcutFieldPrefix();
    }
}
