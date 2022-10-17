package top.kingdon.reggie.service;

import org.springframework.transaction.annotation.Transactional;
import top.kingdon.reggie.entity.CustomException;
import top.kingdon.reggie.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 古德白
* @description 针对表【orders(订单表)】的数据库操作Service
* @createDate 2022-10-17 15:39:35
*/
public interface OrdersService extends IService<Orders> {

    @Transactional
    void submit(Orders orders) throws CustomException;
}
