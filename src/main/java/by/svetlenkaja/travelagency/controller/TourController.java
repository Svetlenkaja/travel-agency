package by.svetlenkaja.travelagency.controller;

import by.svetlenkaja.travelagency.model.entity.Tour;
import by.svetlenkaja.travelagency.service.ClassifierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TourController {
    private final ClassifierService classifierService;

    @GetMapping("/addTour")
    public String addTourView(Model model){
        model.addAttribute("tour", new Object());

        model.addAttribute("tourTypes", classifierService.getTourType());
        model.addAttribute("foodTypes", classifierService.getTourType());
        model.addAttribute("transportTypes", classifierService.getTourType());
        return "add";
    }
}
