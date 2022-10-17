package top.kingdon.reggie.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.kingdon.reggie.entity.AddressBook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 古德白
* @description 针对表【address_book(地址管理)】的数据库操作Mapper
* @createDate 2022-10-17 10:15:41
* @Entity top.kingdon.reggie.entity.AddressBook
*/
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {

}




