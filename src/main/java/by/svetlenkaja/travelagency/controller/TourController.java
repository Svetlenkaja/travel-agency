package by.svetlenkaja.travelagency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TourController {

    @GetMapping("/add")
    public String add(){
        return "welcome";
    }
}
