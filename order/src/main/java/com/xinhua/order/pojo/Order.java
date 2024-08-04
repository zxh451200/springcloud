package  com.xinhua.order.pojo;


import com.xinhua.order.enums.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private Long  id;
    private String name;
    private Integer age;
    private OrderStatus status;
    private Integer deleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private OrderInfo info;
}
