package by.svetlenkaja.travelagency.controller;
import by.svetlenkaja.travelagency.constant.RoleType;
import by.svetlenkaja.travelagency.model.entity.User;
import by.svetlenkaja.travelagency.service.ClassifierService;
import by.svetlenkaja.travelagency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("role", RoleType.values());
        model.addAttribute("url_param", "/registerUser");
        return "addUser";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        user.setRoles(List.of(RoleType.ROLE_CLIENT));
        user.setAccountNonLocked(true);
        try {
            userService.addUser(user);
            return "redirect:/login?register";
        } catch (RuntimeException e) {
            String message = e.getMessage();
            return "redirect:/register?" + message;
        }
    }

    @GetMapping("/createUser")
    public String addUserView(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", RoleType.values());
        model.addAttribute("url_param", "/addUser");
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        user.setAccountNonLocked(true);
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/lockedUser/{idUser}")
    public String lockedUser(@PathVariable long idUser){
        userService.lockedUser(idUser);
        return "redirect:/users";
    }

}
