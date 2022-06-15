package by.svetlenkaja.travelagency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

//    @GetMapping("/")
//    public String SignIn(){
//       return "login";
//    }

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @PostMapping("/login_success_handler")
    public String loginSuccessHandler() {
        //perform audit action
        return "tours";
    }

    @PostMapping("/login_failure_handler")
    public String loginFailureHandler() {
        //perform audit action
        return "login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

}
