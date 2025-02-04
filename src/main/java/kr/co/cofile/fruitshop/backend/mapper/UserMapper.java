package kr.co.cofile.fruitshop.backend.mapper;

import kr.co.cofile.fruitshop.backend.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void save(UserDTO userDTO){
        userDTO.setEnabled(true);


    }
//    void insertUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);


}
