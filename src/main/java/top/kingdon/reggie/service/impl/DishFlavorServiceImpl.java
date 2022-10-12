package top.kingdon.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kingdon.reggie.entity.DishFlavor;
import top.kingdon.reggie.service.DishFlavorService;
import top.kingdon.reggie.mapper.DishFlavorMapper;
import org.springframework.stereotype.Service;

/**
* @author 古德白
* @description 针对表【dish_flavor(菜品口味关系表)】的数据库操作Service实现
* @createDate 2022-10-12 17:29:03
*/
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>
    implements DishFlavorService{

}




