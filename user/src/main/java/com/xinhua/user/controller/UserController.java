package com.xinhua.user.controller;


import com.xinhua.user.domain.pojo.Result;
import com.xinhua.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "用户管理")
public class UserController {


    private final UserService userService;

    @GetMapping("/test")
    public Result test(@RequestHeader(value = "xin",required = false) String xin,@RequestHeader(value = "hua",required = false) String hua) {
        return Result.success("成功"+xin+hua);
    }

    @Operation(summary = "根据ids活的")
    @GetMapping("/getIds/{ids}")
    public Result getIds(@PathVariable("ids")  String ids) {
        System.out.println(1111111111);
        userService.getIds(ids);
        return Result.success();
    }


}
