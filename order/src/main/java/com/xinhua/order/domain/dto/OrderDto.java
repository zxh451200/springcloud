package com.xinhua.order.domain.dto;


import com.xinhua.order.enums.OrderStatus;
import lombok.Data;

@Data
public class OrderDto {
    private Long  id;
    private String name;
    private OrderStatus orderStatus;
    private Integer age;
}
