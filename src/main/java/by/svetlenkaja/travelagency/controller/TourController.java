package by.svetlenkaja.travelagency.controller;

import by.svetlenkaja.travelagency.constant.*;
import by.svetlenkaja.travelagency.editor.CountryEditor;
import by.svetlenkaja.travelagency.editor.LocalDateEditor;
import by.svetlenkaja.travelagency.model.entity.*;
import by.svetlenkaja.travelagency.model.repository.TourRepository;
import by.svetlenkaja.travelagency.service.BookingService;
import by.svetlenkaja.travelagency.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller
@RequiredArgsConstructor
public class TourController {
    private final TourService tourService;
    private final BookingService bookingService;
    private final TourRepository tourRepository;

    @GetMapping("/createTour")
    public String addTourView(Model model) {
        model.addAttribute("tour", new Tour());
        model.addAttribute("tourTypes",  TourType.values());
        model.addAttribute("foodTypes", FoodType.values());
        model.addAttribute("transportTypes", TransportType.values());
        model.addAttribute("countries", tourRepository.getCountries());
        return "addTour";
    }

    @InitBinder("tour")
    public void initBinder(WebDataBinder binder){
        //binder.registerCustomEditor(Classifier.class, new ClassifierEditor(ClassifierType.FOOD.getType()));
        binder.registerCustomEditor(Country.class, new CountryEditor());
        binder.registerCustomEditor(LocalDate.class,new LocalDateEditor());
    }

    @PostMapping("/addTour")
    public String addTour(@ModelAttribute("tour") Tour tour, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            return "addTour";
        }
        tour.setStateType(new Classifier(ClassifierType.STATE.getType(), StateType.AVAILABLE.getCode()));
        tour.setCostWithDiscount(tour.getCost());
        tour.setDiscount(0);
        tourService.addTour(tour);
        return "redirect:/tours";
    }
    @GetMapping("/tours")
    public String showTourList(Model model) {
//        , @DefaultValue("1") @QueryParam("pageNum") int pageNum,
//        @DefaultValue("20") @QueryParam("size") int size
        Page<Tour> tours = tourRepository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.ASC, "id")));
        model.addAttribute("tours", tours.getContent());
        return "tours";
    }

    @GetMapping("/personalTours")
    public String PersonalTours(Model model){
        model.addAttribute("booking", bookingService.getBookingsByUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
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

    @GetMapping("/booking/{id}")
    public String openBooking( @PathVariable long id){
        Tour tour = tourService.getTourById(id);
        bookingService.bookTour(tour, (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "personalTours";
    }


}
