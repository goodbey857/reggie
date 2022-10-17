package top.kingdon.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kingdon.reggie.entity.User;
import top.kingdon.reggie.service.UserService;
import top.kingdon.reggie.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 古德白
* @description 针对表【user(用户信息)】的数据库操作Service实现
* @createDate 2022-10-17 10:46:15
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




