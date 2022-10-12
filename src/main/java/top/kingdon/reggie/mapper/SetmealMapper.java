package top.kingdon.reggie.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.kingdon.reggie.entity.Setmeal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 古德白
* @description 针对表【setmeal(套餐)】的数据库操作Mapper
* @createDate 2022-10-11 20:16:41
* @Entity top.kingdon.reggie.entity.Setmeal
*/
@Mapper
public interface SetmealMapper extends BaseMapper<Setmeal> {

}




