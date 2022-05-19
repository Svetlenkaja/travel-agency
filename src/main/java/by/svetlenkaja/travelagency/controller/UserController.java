package by.svetlenkaja.travelagency.controller;

import by.svetlenkaja.travelagency.model.entity.User;
import by.svetlenkaja.travelagency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String getUsers(){
        List<User> users = userService.getAll();
        return "login";
    }
}
