package top.kingdon.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kingdon.reggie.entity.Dish;
import top.kingdon.reggie.service.DishService;
import top.kingdon.reggie.mapper.DishMapper;
import org.springframework.stereotype.Service;

/**
* @author 古德白
* @description 针对表【dish(菜品管理)】的数据库操作Service实现
* @createDate 2022-10-11 20:16:11
*/
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
    implements DishService{

}




