package com.xinhua.user.domain.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

import java.util.List;

@Data
@Tag(name = "分页结果")
public class PageDto<T> {
    @Parameter(name = "total", description = "总数据数")
    private Long total;
    @Parameter(name = "pages", description = "总页数")
    private Long pages;
    @Parameter(name = "list", description = "数据")
    private List<T> list;


}
