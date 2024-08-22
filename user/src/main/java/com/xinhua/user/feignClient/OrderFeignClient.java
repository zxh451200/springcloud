package com.xinhua.user.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("order-service")
public interface OrderFeignClient {

    @GetMapping("/getIds")
    String getIds() ;//    @GetMapping("/getIds/{ids}")

}
