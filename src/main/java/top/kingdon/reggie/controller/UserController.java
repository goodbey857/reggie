package top.kingdon.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kingdon.reggie.entity.R;
import top.kingdon.reggie.entity.User;
import top.kingdon.reggie.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public R<User> login(@RequestBody Map<String,String> map, HttpSession session){
        String phone = map.get("phone");
        String password = map.get("password");
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(phone!=null,User::getPhone,phone);
        User user = userService.getOne(queryWrapper);
        if(user==null){
            user = new User();
            user.setPhone(phone);
            user.setPassword(password);
            user.setStatus(1);
            userService.save(user);
        }else if(password==null || !password.equals(user.getPassword())){
            return R.error("密码错误");
        }
        session.setAttribute("user",user.getId());
        return R.success(user);

    }
    @PostMapping("/loginout")
    public R<String> loginout(HttpServletRequest request){
        //清理Session中保存的当前用户登录的id
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }
}
