package  com.xinhua.order.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@Schema(description = "用户查询实体")
public class OrderQuery extends PageQuery{
    @Schema(name = "name",description = "名字")
    private String name;
    @Schema(name = "age",description = "年龄")
    private Integer age;

}
