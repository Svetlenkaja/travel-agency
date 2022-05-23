package by.svetlenkaja.travelagency.controller;

import by.svetlenkaja.travelagency.model.entity.Classifier;
import by.svetlenkaja.travelagency.model.entity.User;
import by.svetlenkaja.travelagency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.management.relation.Role;
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

    @GetMapping("/addUser")
    public String addUserView(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/addUser")
    public void addUser (@ModelAttribute("user") User user ){
        Classifier role = new Classifier();
        role.setType(2);
        role.setCode(1);
        user.setRole(role);
        userService.addUser(user);
    }
}
