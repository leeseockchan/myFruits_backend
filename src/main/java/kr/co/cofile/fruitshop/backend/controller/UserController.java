package kr.co.cofile.fruitshop.backend.controller;


import kr.co.cofile.fruitshop.backend.dto.UserDTO;
import kr.co.cofile.fruitshop.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

//    회원가입
    @GetMapping("/auth/signup")
    public String singup() {
        return "/user/signup";
    }
//      회원가입 입력 정보 서버로 전송
    @PostMapping("/auth/signup")
    public String signup(@ModelAttribute UserDTO userDTO) {
        userService.signup(userDTO);

        return "redirect:/auth/login";
    }
    
//    로그인
    @GetMapping("/auth/login")
    public String login() {
        return "/user/login";
    }
    
}
