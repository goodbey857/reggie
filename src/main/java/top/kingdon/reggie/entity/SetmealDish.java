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
 * 套餐菜品关系
 * @TableName setmeal_dish
 */
@TableName(value ="setmeal_dish")
@Data
public class SetmealDish implements Serializable {

    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String setmealId;

    private String dishId;

    private String name;

    private BigDecimal price;

    private Integer copies;

    private Integer sort;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableField(fill = FieldFill.INSERT)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long createUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long updateUser;
    @TableLogic
    private Integer isDeleted;

}