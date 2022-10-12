package top.kingdon.reggie.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * 菜品及套餐分类
 * @TableName category
 */
@TableName(value ="category")
@Data
public class Category implements Serializable {

    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private Integer type;
    private String name;
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

}