package top.kingdon.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kingdon.reggie.entity.AddressBook;
import top.kingdon.reggie.service.AddressBookService;
import top.kingdon.reggie.mapper.AddressBookMapper;
import org.springframework.stereotype.Service;

/**
* @author 古德白
* @description 针对表【address_book(地址管理)】的数据库操作Service实现
* @createDate 2022-10-17 10:15:41
*/
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
    implements AddressBookService{

}




