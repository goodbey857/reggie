package top.kingdon.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import top.kingdon.reggie.entity.Dish;
import top.kingdon.reggie.entity.DishDto;
import top.kingdon.reggie.entity.DishFlavor;
import top.kingdon.reggie.entity.R;
import top.kingdon.reggie.service.DishFlavorService;
import top.kingdon.reggie.service.DishService;
import top.kingdon.reggie.mapper.DishMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author 古德白
* @description 针对表【dish(菜品管理)】的数据库操作Service实现
* @createDate 2022-10-11 20:16:11
*/
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish>
    implements DishService{
    @Autowired
    private DishFlavorService dishFlavorService;


    @Override
    public void saveWithFlavors(DishDto dishDto) {
        this.save(dishDto);
        Long dishId = dishDto.getId();
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map(
                (item) -> {
                    item.setDishId(dishId);
                    return item;
                }
        ).collect(Collectors.toList());
        dishFlavorService.saveBatch(flavors);
    }

    @Override
    public DishDto getByIdWithDishFlavor(Long id) {
        DishDto dishDto = new DishDto();
        Dish dish = this.getById(id);
        BeanUtils.copyProperties(dish,dishDto);

        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId,dish.getId());
        List<DishFlavor> list = dishFlavorService.list(queryWrapper);
        dishDto.setFlavors(list);
        return dishDto;
    }

    @Override
    public void updateWithDishFlavor(DishDto dishDto) {
        this.updateById(dishDto);
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId,dishDto.getId());
        dishFlavorService.remove(queryWrapper);

        List<DishFlavor> list = dishDto.getFlavors();
        list = list.stream().map((item) -> {
            item.setDishId(dishDto.getId());

            return item;
        }).collect(Collectors.toList());
        dishFlavorService.saveBatch(list);
    }



}




