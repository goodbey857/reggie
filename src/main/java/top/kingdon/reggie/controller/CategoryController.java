package top.kingdon.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.kingdon.reggie.entity.AssociatedException;
import top.kingdon.reggie.entity.Category;
import top.kingdon.reggie.entity.R;
import top.kingdon.reggie.service.CategoryService;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public R<String> save(@RequestBody Category category){
        log.info("添加分类："+category.getName());
        categoryService.save(category);
        return R.success("添加分类成功");
    }

    @GetMapping("/page")
    public R<Page> page(int page,int pageSize){
        Page<Category> pageInfo = new Page<Category>();
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Category::getSort);
        categoryService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);

    }

    @DeleteMapping
    public R<String> delete(Long ids) throws AssociatedException {
        categoryService.remove(ids);
        return R.success("分类移除成功");

    }

    @PutMapping
    public R<String>update(@RequestBody Category category){
        categoryService.updateById(category);
        return R.success("更新分类信息成功");
    }
}
