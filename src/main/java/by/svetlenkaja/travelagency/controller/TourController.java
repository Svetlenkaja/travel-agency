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
//        model.addAttribute("foodType", new Classifier());
//        model.addAttribute("transportType", new Classifier());
//        model.addAttribute("foodTypes", classifierService.getFoodTypes());
//        model.addAttribute("transportTypes", classifierService.getTransportTypes());
        return "add-tour";
    }

    @InitBinder("tour")
    public void initBinder(WebDataBinder binder){
        //binder.registerCustomEditor(Classifier.class, new ClassifierEditor(ClassifierType.FOOD.getType()));
    }

    @PostMapping("/addTour")
    public String addTour(@ModelAttribute("tour") Tour tour, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "add-tour";
        }
        tour.setStateType(new Classifier(ClassifierType.STATE.getType(), StateType.AVAILABLE.getCode()));
        tourService.addTour(tour);
        model.addAttribute("tours", tourService.getAll());
        return "tours";
    }

    @GetMapping("/tours")
    public String showTourList(Model model) {
        model.addAttribute("tours", tourService.getAll());
        return "tours";
    }

    @GetMapping("/personalTours")
    public String PersonalTours(){
        return "my-tours";
    }

    @GetMapping("tour/{id}")
    public String TourDetails(@PathVariable long id, Model model){
        model.addAttribute("tour", tourService.getTourById(id));
        return "tour-details";
    }
}
