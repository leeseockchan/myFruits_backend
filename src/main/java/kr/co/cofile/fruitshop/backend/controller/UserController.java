package kr.co.cofile.fruitshop.backend.controller;


import kr.co.cofile.fruitshop.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
//    회원가입
    @GetMapping("/signup")
    public String singup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("password") String password) {
        userService.signup(username, password);
        return "redirect:/login";
    }
}
