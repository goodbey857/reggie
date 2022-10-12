package top.kingdon.reggie.intercaptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.kingdon.reggie.entity.AssociatedException;
import top.kingdon.reggie.entity.R;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice(annotations = {RestController.class, Controller.class})
// @ControllerAdvice主要用来处理全局数据，一般搭配@ExceptionHandler、@ModelAttribute以及@InitBinder使用。
// @ControllerAdvice 的annotations属性是用来限制ControllerAdvice的作用范围
@ResponseBody
@Slf4j
public class GlobalExceptionhandler {

    //@ExceptionHandle的作用是用来捕获全局异常
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> doubleUsernameException(SQLIntegrityConstraintViolationException e){
        log.error(e.getMessage());
        if(e.getMessage().contains("Duplicate entry")){
            String[] split = e.getMessage().split(" ");
            String msg=split[2]+"已存在";
            return R.error(msg);
        }
        return R.error("未知错误");
    }

    @ExceptionHandler(AssociatedException.class)
    public R<String> associateException(AssociatedException e){
        log.error(e.getMessage());
        return R.error("存在关联的菜品");
    }
}
