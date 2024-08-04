package com.xinhua.order.service;

import com.xinhua.order.dto.PageDto;
import com.xinhua.order.pojo.Order;
import com.xinhua.order.query.OrderQuery;
import com.xinhua.order.vo.OrderVo;

import java.util.List;

public interface OrderService {


    void deductAge(Long id, Integer age) throws Exception;


    List<Order> getByName(String name, Long age);

    PageDto<OrderVo> getPageUserList(OrderQuery userQuery);
}
