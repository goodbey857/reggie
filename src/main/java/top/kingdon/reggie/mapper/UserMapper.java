package top.kingdon.reggie.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.kingdon.reggie.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 古德白
* @description 针对表【user(用户信息)】的数据库操作Mapper
* @createDate 2022-10-17 10:46:15
* @Entity top.kingdon.reggie.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




