package by.svetlenkaja.travelagency.controller;

import by.svetlenkaja.travelagency.constant.*;
import by.svetlenkaja.travelagency.editor.ClassifierEditor;
import by.svetlenkaja.travelagency.model.entity.*;
import by.svetlenkaja.travelagency.service.ClassifierService;
import by.svetlenkaja.travelagency.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Controller
@RequiredArgsConstructor
public class TourController {
    private final ClassifierService classifierService;
    private final TourService tourService;

    @GetMapping("/createTour")
    public String addTourView(Model model) {
        model.addAttribute("tour", new Tour());
        model.addAttribute("tourTypes",  TourType.values());
        model.addAttribute("foodTypes", FoodType.values());
        model.addAttribute("transportTypes", TransportType.values());
        return "addTour";
    }

    @InitBinder("tour")
    public void initBinder(WebDataBinder binder){
        //binder.registerCustomEditor(Classifier.class, new ClassifierEditor(ClassifierType.FOOD.getType()));
    }

    @PostMapping("/addTour")
    public String addTour(@ModelAttribute("tour") Tour tour, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "addTour";
        }
        tour.setStateType(new Classifier(ClassifierType.STATE.getType(), StateType.AVAILABLE.getCode()));
        tourService.addTour(tour);
        return "redirect:/tours";
    }
    @GetMapping("/tours")
    public String showTourList(Model model) {
        model.addAttribute("tours", tourService.getAll());
        return "tours";
    }

    @GetMapping("/personalTours")
    public String PersonalTours(Model model){
        model.addAttribute("tours", tourService.getAll());
        return "personalTours";
    }

    @GetMapping("tour/{id}")
    public String TourDetails(@PathVariable long id, Model model){
        model.addAttribute("tour", tourService.getTourById(id));
        return "tourDetails";
    }

    @GetMapping("/tour/edit/{id}")
    public String updateTour(@PathVariable long id, Model model){
        model.addAttribute("tour", tourService.getTourById(id));
        return "tourDetails";
    }

}
