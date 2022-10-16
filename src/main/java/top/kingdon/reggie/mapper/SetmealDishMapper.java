package top.kingdon.reggie.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.kingdon.reggie.entity.SetmealDish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 古德白
* @description 针对表【setmeal_dish(套餐菜品关系)】的数据库操作Mapper
* @createDate 2022-10-14 11:18:17
* @Entity top.kingdon.reggie.entity.SetmealDish
*/
@Mapper
public interface SetmealDishMapper extends BaseMapper<SetmealDish> {

}




