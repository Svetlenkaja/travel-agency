package by.svetlenkaja.travelagency.controller;

import by.svetlenkaja.travelagency.constant.StateType;
import by.svetlenkaja.travelagency.constant.ClassifierType;
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
        model.addAttribute("tour", new RestTour());
        model.addAttribute("tourType", new Classifier());
        model.addAttribute("foodType", new Classifier());
        model.addAttribute("transportType", new Classifier());
        model.addAttribute("tourTypes", classifierService.getTourTypes());
        model.addAttribute("foodTypes", classifierService.getFoodTypes());
        model.addAttribute("transportTypes", classifierService.getTransportTypes());
        return "add-tour";
    }

    @InitBinder("tour")
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Classifier.class, new ClassifierEditor(ClassifierType.TOUR.getType()));
    }

    @PostMapping("/addTour")
    public String addTour(@ModelAttribute("tour") RestTour tour, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "add-tour";
        }
        Hotel hotel = new Hotel();
        hotel.setId(1);
        tour.setHotel(hotel);
        tour.setStateType(new Classifier(ClassifierType.STATE.getType(), StateType.AVAILABLE.getCode()));
        tourService.addRestTour(tour);
        //model.addAttribute("tours", tourService.getAll());
        return "tours";
    }
//    @GetMapping("/addTour")
//    public String addTour(@RequestParam(required = false) String radioTourType,
//                          @RequestParam(required = false) String calendar,
//                          @RequestParam(required = false) int numberOfNights,
//                          @RequestParam(required = false) int cost,
//                          @RequestParam(required = false) String foodType,
//                          @RequestParam(required = false) String transportType,
//                          Model model) {
//        if (Integer.parseInt(radioTourType) == 1) {
//            RestTour tour = new RestTour();
//            tour.setTourType(new Classifier(3, 1));
//          //  tour.setDateOfDeparture(LocalDateTime.parse(calendar));
//            tour.setTransportType(new Classifier(ClassifierType.TRANSPORT.getType(), Integer.parseInt(transportType)));
//            tour.setNumberOfNights(numberOfNights);
//            tour.setFoodType(new Classifier(ClassifierType.FOOD.getType(), Integer.parseInt(foodType)));
//            tour.setStateType(new Classifier(ClassifierType.STATE.getType(), StateType.AVAILABLE.getCode()));
//            tour.setCost(cost);
//            tourService.addRestTour(tour);
//        }
//        model.addAttribute("tours", tourService.getAll());
//        return "tours";
//    }

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
    public String TourDetails(Model model, @RequestParam long id){
        model.addAttribute("tour", tourService.getTourById(id));
        return "tour-details";
    }
}
