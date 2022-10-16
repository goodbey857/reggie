package top.kingdon.reggie.service;

import top.kingdon.reggie.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;
import top.kingdon.reggie.entity.DishDto;

/**
* @author 古德白
* @description 针对表【dish(菜品管理)】的数据库操作Service
* @createDate 2022-10-11 20:16:11
*/
public interface DishService extends IService<Dish> {
    void saveWithFlavors(DishDto dishDto);
    DishDto getByIdWithDishFlavor(Long id);
    void updateWithDishFlavor(DishDto dishDto);
}
