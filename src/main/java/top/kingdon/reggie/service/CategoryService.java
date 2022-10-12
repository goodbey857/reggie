package top.kingdon.reggie.service;

import org.springframework.stereotype.Service;
import top.kingdon.reggie.entity.AssociatedException;
import top.kingdon.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 古德白
* @description 针对表【category(菜品及套餐分类)】的数据库操作Service
* @createDate 2022-10-11 17:00:58
*/

public interface CategoryService extends IService<Category> {
    boolean remove(Long id) throws AssociatedException;
}
