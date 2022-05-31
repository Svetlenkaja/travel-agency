package by.svetlenkaja.travelagency.controller;

import by.svetlenkaja.travelagency.constant.ClassifierType;
import by.svetlenkaja.travelagency.editor.ClassifierEditor;
import by.svetlenkaja.travelagency.model.entity.Classifier;

import by.svetlenkaja.travelagency.model.entity.User;
import by.svetlenkaja.travelagency.service.ClassifierService;
import by.svetlenkaja.travelagency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ClassifierService classifierService;

    @GetMapping("/users")
    public String getUsers() {
        List<User> users = userService.getAll();
        return "login";
    }

    @GetMapping("/createUser")
    public String addUserView(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("role", new Classifier());
        model.addAttribute("roles", classifierService.getRoles());
        return "add-user";
    }

    @InitBinder("user")
    public void initBinder(WebDataBinder binder){
//       binder.setDisallowedFields("role");
     binder.registerCustomEditor(Classifier.class, new ClassifierEditor(ClassifierType.ROLE.getType()));
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "home";
    }




}
