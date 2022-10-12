package top.kingdon.reggie.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.kingdon.reggie.entity.Dish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 古德白
* @description 针对表【dish(菜品管理)】的数据库操作Mapper
* @createDate 2022-10-11 20:16:11
* @Entity top.kingdon.reggie.entity.Dish
*/
@Mapper
public interface DishMapper extends BaseMapper<Dish> {

}




