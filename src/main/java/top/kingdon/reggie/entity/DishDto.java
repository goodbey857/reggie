package top.kingdon.reggie.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish{

    private List<DishFlavor> flavors = new ArrayList<DishFlavor>();
    private String categoryName;
    private String copies;


}
