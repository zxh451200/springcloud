package com.xinhua.user.service;


import api.client.OrderFeign;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final RestTemplate restTemplate;


    private final DiscoveryClient discoveryClient;

    private final OrderFeign orderFeign;

    @Override
    public void getIds(String ids) {
////        第一种
        orderFeign.getIds();
/*
//        第二种
        String orderServiceStr = "order-service";
        List<ServiceInstance> instances = discoveryClient.getInstances(orderServiceStr);
        if (CollUtil.isEmpty(instances)) {
            return;
        }
        ServiceInstance serviceInstance = instances.get(RandomUtil.randomInt(instances.size()));
//        注册中心,如果在main中打开了LoadBalanced,注解这里就要用域名,否则用ip
//        String url = serviceInstance.getUri() + "/order/getIds";
        String url = String.format("http://%s/order/getIds", orderServiceStr);
        System.out.println(url);
//        restTemplate.getForObject(url,String.class);

        ResponseEntity<String> exchange = restTemplate.exchange(
                url,//请求路径
                HttpMethod.GET,//请求方式
                null,//请求实体
                new ParameterizedTypeReference<String>() {
                },//返回值类型
                Map.of("ids", ids)//请求参数
        );

 */
    }


}
