package top.kingdon.reggie.intercaptor;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import top.kingdon.reggie.utils.BaseContext;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class MyMetaObjectHandle implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Long empId = BaseContext.getCurrentId();
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("createUser",empId);
        metaObject.setValue("updateUser",empId);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Long empId = BaseContext.getCurrentId();
        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("updateUser",empId);
    }
}
