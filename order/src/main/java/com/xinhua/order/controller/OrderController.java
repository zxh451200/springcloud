package  com.xinhua.order.controller;


import cn.hutool.core.bean.BeanUtil;
import com.xinhua.order.dto.OrderDto;
import com.xinhua.order.pojo.Order;
import com.xinhua.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Tag(name = "订单管理")
public class OrderController {

    @Autowired
    private final OrderService orderService;


    @Operation(summary = "插入用户")
    @PostMapping("insert")
    public void insertUser(@RequestBody OrderDto userDto){
       //   User user = new User();
        Order order = BeanUtil.copyProperties(userDto, Order.class);
    }

    @Operation(summary = "根据ids活的")
    @GetMapping("/getIds/{ids}")
    public void getIds(@PathVariable("ids") String ids) {
        System.out.println(5566546);


    }


}
