package by.svetlenkaja.travelagency.controller;

import by.svetlenkaja.travelagency.constant.TypeClassifier;
import by.svetlenkaja.travelagency.model.entity.Classifier;
import by.svetlenkaja.travelagency.model.entity.RestTour;
import by.svetlenkaja.travelagency.service.ClassifierService;
import by.svetlenkaja.travelagency.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TourController {
    private final ClassifierService classifierService;
private final TourService tourService;
    @GetMapping("/createTour")
    public String addTourView(Model model){
        model.addAttribute("tour", new Object());

        model.addAttribute("tourTypes", classifierService.getTourTypes());
        model.addAttribute("foodTypes", classifierService.getFoodTypes());
        model.addAttribute("transportTypes", classifierService.getTransportTypes());
        return "add";
    }

    @GetMapping ("/addTour")
    public String addTour(@RequestParam(required = false) String radioTourType,
                          @RequestParam(required = false) String calendar,
                          @RequestParam(required = false) int numberOfNights,
                          @RequestParam(required = false) int cost,
                          @RequestParam(required = false) String foodType,
                          @RequestParam(required = false) String transportType,
                          Model model) {

                RestTour tour = new RestTour();
                tour.setTypeTour(new Classifier(3, 1));
                tour.setTransportTour(new Classifier(TypeClassifier.TRANSPORT.getType(), 1));
                tour.setNumberOfNights(numberOfNights);
                tour.setFoodType(new Classifier(TypeClassifier.FOOD.getType(), 1));
                tourService.addRestTour(tour);

        return "home";
    }

    @GetMapping("/list")
    public String showTourList(Model model) {
        model.addAttribute("tours", tourService.getAll());
        return "list";
    }
}
