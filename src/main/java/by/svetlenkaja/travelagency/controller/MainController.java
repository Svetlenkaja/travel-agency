package by.svetlenkaja.travelagency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @GetMapping(value={"", "/", "home"})
    public String home(){
        return "home";
    }

}
