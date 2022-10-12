package top.kingdon.reggie.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.kingdon.reggie.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 古德白
* @description 针对表【category(菜品及套餐分类)】的数据库操作Mapper
* @createDate 2022-10-11 17:00:58
* @Entity top.kingdon.reggie.entity.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




