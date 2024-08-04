package  com.xinhua.order.vo;

import com.xinhua.order.enums.OrderStatus;
import com.xinhua.order.pojo.OrderInfo;
import lombok.Data;

@Data
public class OrderVo {
    private Long  id;
    private String name;
    private Integer age;
    private OrderStatus status;
    private OrderInfo info;
}
