package  com.xinhua.order.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "分页户查询实体")
public class PageQuery {
    @Schema(name = "pageNo", description = "页码")
    private Integer pageNo;
    @Schema(name = "pageSize", description = "条数")
    private Integer pageSize;
    @Schema(name = "sortBy", description = "排序字段")
    private String sortBy;
    @Schema(name = "isAsc", description = "是否升序")
    private Boolean isAsc;


}
