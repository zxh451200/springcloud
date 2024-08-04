package com.xinhua.user.controller;


import com.xinhua.user.pojo.Result;
import com.xinhua.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "用户管理")
public class UserController {



    private final UserService userService;




    @Operation(summary = "根据ids活的")
    @GetMapping("/getIds/{ids}")
    public Result getIds(@PathVariable("ids")  String ids) {
        userService.getIds(ids);
        return Result.success();
    }

//    @Operation(summary = "根据ids活的")
//    @GetMapping("/getIds/{ids}")
//    public Result<List<UserDto>> getIds(@PathVariable String ids) {
//        String orderServiceStr = "order-service-dev";
//        List<ServiceInstance> instances = discoveryClient.getInstances(orderServiceStr);
//        if (CollUtil.isEmpty(instances)) {
//            return null;
//        }
//        ServiceInstance serviceInstance = instances.get(RandomUtil.randomInt(instances.size()));
//        String url = serviceInstance.getUri() + "/order/{ids}";
//
//        System.out.println(url);
//        System.out.println(66666666);
//
//        ResponseEntity<List<UserDto>> exchange = restTemplate.exchange(
//                url,//请求路径
//                HttpMethod.GET,//请求方式
//                null,//请求实体
//                new ParameterizedTypeReference<List<UserDto>>() {},//返回值类型
//                Map.of("ids", ids)//请求参数
//        );
//        return Result.success(exchange.getBody());
//    }


//    @Operation(summary = "根据ids活的")
//    @GetMapping("/getIdsx")
//    public Result<List<UserDto>> getIdsx(List<UserVo> vos) {
//
//        Set<Long> itemIds = vos.stream().map(vo -> vo.getId()).collect(Collectors.toSet());
//
//        String orderServiceStr = "order-service-dev";
//
//        List<ServiceInstance> instances = discoveryClient.getInstances(orderServiceStr);
//        if (CollUtil.isNotEmpty(instances)) {
//            return null;
//        }
//        ServiceInstance serviceInstance = instances.get(RandomUtil.randomInt(instances.size()));
//        ResponseEntity<List<UserDto>> exchange = restTemplate.exchange(
//                serviceInstance.getUri() + "/order/{ids}",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<>() {
//                },
//                Map.of("ids", CollUtil.join(itemIds, ","))
//        );
//
//        return Result.success(exchange.getBody());
//
//
//    }


}
