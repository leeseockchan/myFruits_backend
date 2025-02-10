package kr.co.cofile.fruitshop.backend.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface APIUserMapper {
    void save(UserDTO userDTO);
    void insertUserRole(@Param("userId") int userId, @Param("roleId") int roleId);
}
