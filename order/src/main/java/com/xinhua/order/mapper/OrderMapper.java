package  com.xinhua.order.mapper;

import com.xinhua.order.domain.pojo.Order;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderMapper  {

    @Update("update order set age=age-#{age} where id = #{id}")
    void deductAge(Long id, Integer age);
    @Select("select * from user where name like  CONCAT('%', #{name}, '%') and age=#{age}")
    List<Order> getByName(String name, Long age);
}
