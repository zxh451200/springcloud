package api.client;

import api.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("order-service-dev")
public interface OrderFeign {

    @GetMapping("/getIds/{ids}")
    List<UserDto> getIds(@PathVariable("ids") String ids) ;//    @GetMapping("/getIds/{ids}")



}
