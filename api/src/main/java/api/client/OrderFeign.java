package api.client;

import api.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "order-service",configuration = FeignClientConfig.class)
public interface OrderFeign {

    @GetMapping("/order/getIds")
    String getIds() ;//    @GetMapping("/getIds/{ids}")



}
