package top.kingdon.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import top.kingdon.reggie.entity.AssociatedException;
import top.kingdon.reggie.entity.Category;
import top.kingdon.reggie.entity.Dish;
import top.kingdon.reggie.entity.Setmeal;
import top.kingdon.reggie.service.CategoryService;
import top.kingdon.reggie.mapper.CategoryMapper;
import org.springframework.stereotype.Service;
import top.kingdon.reggie.service.DishService;
import top.kingdon.reggie.service.SetmealService;

/**
* @author 古德白
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service实现
* @createDate 2022-10-11 17:00:58
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;
    @Override
    public boolean remove(Long id) throws AssociatedException {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<Dish>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int dishCount = dishService.count(dishLambdaQueryWrapper);

        LambdaQueryWrapper<Setmeal> setmealQueryWrapper = new LambdaQueryWrapper<Setmeal>();
        setmealQueryWrapper.eq(Setmeal::getCategoryId,id);
        int setmealCount = setmealService.count(setmealQueryWrapper);

        if(dishCount>0 || setmealCount>0){
            throw new AssociatedException("已关联菜单，不能删除");
        }
        super.removeById(id);
        return true;

    }
}




