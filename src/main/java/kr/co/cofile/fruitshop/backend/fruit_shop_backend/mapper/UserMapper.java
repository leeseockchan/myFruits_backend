package kr.co.cofile.fruitshop.backend.fruit_shop_backend.mapper;

import kr.co.cofile.fruitshop.backend.fruit_shop_backend.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    void save(UserDTO user);
    void insertUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);


}
