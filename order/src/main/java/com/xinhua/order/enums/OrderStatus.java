package  com.xinhua.order.enums;


import lombok.Getter;

@Getter
public enum OrderStatus {


    NORMAL("正常"),
    FROZEN("冻结"),
    ;

    private String desc;

    OrderStatus(String desc) {
        this.desc = desc;
    }
}
