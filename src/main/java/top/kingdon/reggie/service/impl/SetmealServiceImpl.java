package top.kingdon.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import top.kingdon.reggie.entity.Setmeal;
import top.kingdon.reggie.entity.SetmealDish;
import top.kingdon.reggie.entity.SetmealDto;
import top.kingdon.reggie.service.SetmealDishService;
import top.kingdon.reggie.service.SetmealService;
import top.kingdon.reggie.mapper.SetmealMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author 古德白
* @description 针对表【setmeal(套餐)】的数据库操作Service实现
* @createDate 2022-10-11 20:16:41
*/
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal>
    implements SetmealService{

    @Autowired
    private SetmealDishService setmealDishService;

    @Override
    public void saveWithDish(SetmealDto setmealDto) {
        this.save(setmealDto);
        List<SetmealDish> dishes = setmealDto.getSetmealDishes();
        dishes = dishes.stream().map((item)->{
            item.setSetmealId(String.valueOf(setmealDto.getId()));
            return item;
        }).collect(Collectors.toList());
        setmealDishService.saveBatch(dishes);

    }
    @Override
    public SetmealDto getByIdWithDish(Long id) {
        //查询套餐基本信息
        Setmeal setmeal = this.getById(id);
        SetmealDto setmealDto = new SetmealDto();
        BeanUtils.copyProperties(setmeal, setmealDto);

        //查询套餐菜品信息
        LambdaQueryWrapper<SetmealDish> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(SetmealDish::getSetmealId,setmeal.getId());
        List<SetmealDish> list = setmealDishService.list(queryWrapper);

        setmealDto.setSetmealDishes(list);
        return setmealDto;
    }
    @Override
    public void updateWithDish(SetmealDto setmealDto) {
        //更新setmeal表基本信息
        this.updateById(setmealDto);

        //更新setmeal_dish表信息delete操作
        LambdaQueryWrapper<SetmealDish> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SetmealDish::getSetmealId, setmealDto.getId());
        setmealDishService.remove(queryWrapper);

        //更新setmeal_dish表信息insert操作
        List<SetmealDish> SetmealDishes = setmealDto.getSetmealDishes();

        SetmealDishes = SetmealDishes.stream().map((item) -> {
            item.setSetmealId(String.valueOf(setmealDto.getId()));
            return item;
        }).collect(Collectors.toList());

        setmealDishService.saveBatch(SetmealDishes);
    }
}




