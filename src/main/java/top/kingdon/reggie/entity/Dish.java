package top.kingdon.reggie.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;


@TableName(value ="dish")
@Data
public class Dish implements Serializable {

    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId;
    private BigDecimal price;
    private String code;
    private String image;
    private String description;
    private Integer status;
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
    @TableLogic     //逻辑删除
    private Integer isDeleted;

}