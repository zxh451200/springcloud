package api.client;

import api.client.fallback.OrderFeignClientFallbackFactory;
import api.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "order-service",configuration = FeignClientConfig.class,fallbackFactory = OrderFeignClientFallbackFactory.class)
public interface OrderFeignClient {

    @GetMapping("/order/getIds")
    String getIds() ;//    @GetMapping("/getIds/{ids}")



}
