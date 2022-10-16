package top.kingdon.reggie.entity;

import lombok.Data;
import top.kingdon.reggie.entity.Setmeal;
import top.kingdon.reggie.entity.SetmealDish;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;
    private String categoryName;
}