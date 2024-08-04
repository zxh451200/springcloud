package com.xinhua.user.service;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import com.xinhua.user.feignClient.OrderFeign;
import com.xinhua.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{



    private final RestTemplate restTemplate;


    private final DiscoveryClient discoveryClient;

    private final OrderFeign orderFeign;

    @Override
    public void getIds(String ids) {
////        第一种
//        orderFeign.getIds(ids);

//        第二种
        String orderServiceStr = "order-service-dev";
        List<ServiceInstance> instances = discoveryClient.getInstances(orderServiceStr);
        if (CollUtil.isEmpty(instances)) {
            return ;
        }

        ServiceInstance serviceInstance = instances.get(RandomUtil.randomInt(instances.size()));
        String url = serviceInstance.getUri() + "/order/{ids}";

        System.out.println(url);
        System.out.println(66666666);

        ResponseEntity<List<UserDto>> exchange = restTemplate.exchange(
                url,//请求路径
                HttpMethod.GET,//请求方式
                null,//请求实体
                new ParameterizedTypeReference<List<UserDto>>() {},//返回值类型
                Map.of("ids", ids)//请求参数
        );



    }
}
