package kr.co.cofile.fruitshop.backend.service;

import kr.co.cofile.fruitshop.backend.dto.UserDTO;
import kr.co.cofile.fruitshop.backend.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public void signup(String username, String password){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setPassword(password);

        userMapper.save(userDTO);
    }

}
