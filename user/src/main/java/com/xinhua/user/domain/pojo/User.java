package com.xinhua.user.domain.pojo;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Long  id;
    private String name;
    private Integer age;
    private Integer deleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
