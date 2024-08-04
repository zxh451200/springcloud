package  com.xinhua.order.service;


import com.xinhua.order.dto.PageDto;
import com.xinhua.order.pojo.Order;
import com.xinhua.order.query.OrderQuery;
import com.xinhua.order.vo.OrderVo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
//继承ServiceImpl，实现UserService
public class UserServiceImpl implements OrderService {

    @Override
    public void deductAge(Long id, Integer age) throws Exception {

    }

    @Override
    public List<Order> getByName(String name, Long age) {
        return null;
    }

    @Override
    public PageDto<OrderVo> getPageUserList(OrderQuery userQuery) {
        return null;
    }
}
