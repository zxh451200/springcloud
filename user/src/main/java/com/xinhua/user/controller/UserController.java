package com.xinhua.user.controller;


import com.xinhua.user.config.OrderProperties;
import com.xinhua.user.domain.pojo.Result;
import com.xinhua.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "用户管理")
public class UserController {


    private final UserService userService;

    private final OrderProperties oderProperties;

    private final RabbitTemplate rabbitTemplate;

    @GetMapping("/fanoutSendMsg")
    public Result fanoutSendMsg(@RequestHeader(value = "xin",required = false) String xin,@RequestHeader(value = "hua",required = false) String hua) {

        for (int i = 0; i < 10; i++) {
            String queueName = "my_queue";
//            String message = "我是一个消息"+i;

            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
            objectObjectHashMap.put("name","张三");

            rabbitTemplate.convertAndSend(queueName,objectObjectHashMap);

        }

        return Result.success("成功"+xin+hua+"nacos热更新属性:"+oderProperties.getOrderName());
    }



//
//    @RabbitListener(queues = "my_queue")
//    public void tests(String msg) {
//        System.out.println("消费消息1:"+msg);
//    }
//
//    @RabbitListener(queues = "my_queue")
//    public void testss(String msg) throws InterruptedException {
//        Thread.sleep(200);
//        System.out.println("消费消息2:"+msg);
//    }
//
//    @RabbitListener(queues = "hua1")
//    public void hua1(String msg){
//        System.out.println("hua1:"+msg);
//    }
//
//    @RabbitListener(queues = "hua2")
//    public void hua2(String msg){
//        System.out.println("hua2:"+msg);
//    }
//
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(name="hua_queue",durable = "true"),
//            exchange = @Exchange(name="hua_exchange",type = ExchangeTypes.TOPIC,durable = "true"),
//            key ={"red","blue"}
//    ))
//    public void allHua1(String msg){
//        System.out.println("all-hua1:"+msg);
//    }

    @GetMapping("/directSendMsg")
    public void directSendMsg(@RequestParam(name = "exchange") String exchange,@RequestParam(name = "routingKey") String routingKey,@RequestParam(name = "msg") String msg){
        rabbitTemplate.convertAndSend(exchange,routingKey,msg);
    }



    @Operation(summary = "根据ids活的")
    @GetMapping("/getIds/{ids}")
    public Result getIds(@PathVariable("ids")  String ids) {
        System.out.println(1111111111);
        userService.getIds(ids);
        return Result.success();
    }


}
