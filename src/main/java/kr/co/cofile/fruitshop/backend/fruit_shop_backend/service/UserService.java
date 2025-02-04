package kr.co.cofile.fruitshop.backend.fruit_shop_backend.service;

import kr.co.cofile.fruitshop.backend.fruit_shop_backend.dto.UserDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public void signup(){
        void save(UserDTO userDTO);
        void insertUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    }
}
