package kr.co.cofile.fruitshop.backend.fruit_shop_backend.controller;


import kr.co.cofile.fruitshop.backend.fruit_shop_backend.dto.UserDTO;
import kr.co.cofile.fruitshop.backend.fruit_shop_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

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
