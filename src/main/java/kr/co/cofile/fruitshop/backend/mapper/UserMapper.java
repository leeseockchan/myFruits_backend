package kr.co.cofile.fruitshop.backend.mapper;

import kr.co.cofile.fruitshop.backend.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    void save(UserDTO userDTO);
//    void insertUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);


}
