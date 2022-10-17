package top.kingdon.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kingdon.reggie.entity.ShoppingCart;
import top.kingdon.reggie.service.ShoppingCartService;
import top.kingdon.reggie.mapper.ShoppingCartMapper;
import org.springframework.stereotype.Service;

/**
* @author 古德白
* @description 针对表【shopping_cart(购物车)】的数据库操作Service实现
* @createDate 2022-10-17 15:23:08
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
    implements ShoppingCartService{

}




