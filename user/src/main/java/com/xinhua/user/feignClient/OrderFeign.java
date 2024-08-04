package com.xinhua.user.feignClient;

import com.xinhua.user.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("order-service-dev")
public interface OrderFeign {

    @GetMapping("/order/getIds")
    String getIds() ;//    @GetMapping("/getIds/{ids}")

}
