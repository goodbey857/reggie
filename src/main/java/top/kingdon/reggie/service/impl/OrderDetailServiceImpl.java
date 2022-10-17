package top.kingdon.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kingdon.reggie.entity.OrderDetail;
import top.kingdon.reggie.service.OrderDetailService;
import top.kingdon.reggie.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author 古德白
* @description 针对表【order_detail(订单明细表)】的数据库操作Service实现
* @createDate 2022-10-17 15:47:25
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
    implements OrderDetailService{

}




