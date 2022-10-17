package top.kingdon.reggie.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * 购物车
 * @TableName shopping_cart
 */
@TableName(value ="shopping_cart")
@Data
public class ShoppingCart implements Serializable {

    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;

    private String image;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long dishId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long setmealId;

    private String dishFlavor;

    private Integer number;

    private BigDecimal amount;
    private LocalDateTime createTime;

}