package top.kingdon.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data       //实体类实现序列化接口的目的是：将HttpSession对象保存到文件系统或数据库中，需要采用序列化的方式将HttpSession对象中的每个属性对象保存到文件系统或数据库中；将HttpSession对象从文件系统或数据库中装载如内存时，需要采用反序列化的方式，恢复HttpSession对象中的每个属性对象。所以存储在HttpSession对象中的每个属性对象必须实现Serializable接口。
public class Employee implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)    //将long类型的数据转换为字符串传递给前端，解决前端的long类型的精度丢失问题
    private Long id;
    String name;
    String username;
    String password;
    String phone;
    String sex;
    String idNumber;
    Integer status;
    @TableField(fill = FieldFill.INSERT)
    LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    LocalDateTime updateTime;
    @TableField(fill = FieldFill.INSERT)
    @JsonSerialize(using = ToStringSerializer.class)
    Long createUser;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonSerialize(using = ToStringSerializer.class)
    Long updateUser;
}
