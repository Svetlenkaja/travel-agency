package by.svetlenkaja.travelagency.controller;

import by.svetlenkaja.travelagency.constant.*;
import by.svetlenkaja.travelagency.editor.CountryEditor;
import by.svetlenkaja.travelagency.editor.LocalDateEditor;
import by.svetlenkaja.travelagency.model.entity.*;
import by.svetlenkaja.travelagency.model.repository.TourRepository;
import by.svetlenkaja.travelagency.service.BookingService;
import by.svetlenkaja.travelagency.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/tours")
public class TourController {
    private final TourService tourService;
    private final TourRepository tourRepository;
    private static final int PAGE_SIZE = 10;

    @GetMapping("/createTour")
    public String addTourView(Model model) {
        model.addAttribute("tour", new Tour());
        model.addAttribute("tourTypes", TourType.values());
        model.addAttribute("foodTypes", FoodType.values());
        model.addAttribute("transportTypes", TransportType.values());
        model.addAttribute("discounts", DiscountType.values());
        model.addAttribute("countries", tourRepository.getCountries());
        return "addTour";
    }

    @InitBinder("tour")
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Country.class, new CountryEditor());
        binder.registerCustomEditor(LocalDate.class, new LocalDateEditor());
    }

    @PostMapping("/addTour")
    public String addTour(@ModelAttribute("tour") Tour tour, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addTour";
        }
        try {
            tourService.addTour(tour);
            return "redirect:/tours";
        } catch (RuntimeException e){
            String message = e.getMessage();
            model.addAttribute("tourTypes", TourType.values());
//            model.addAttribute("foodTypes", FoodType.values());
            model.addAttribute("transportTypes", TransportType.values());
            model.addAttribute("discounts", DiscountType.values());
            model.addAttribute("countries", tourRepository.getCountries());
            model.addAttribute("message", message);
            return "addTour";
        }

    }

    @GetMapping(value = {"", "/{page}"})
    public String showTourList(Model model,
                               @PathVariable(required = false, name = "page") String page,
                               @RequestParam(required = false) String sortedType) {
        if (page == null) {
            page = "0";
        }
        int lastPage;
        long totalTours = tourRepository.count(); //total no of tours
        if (totalTours % PAGE_SIZE != 0)
            lastPage = (int) (totalTours / PAGE_SIZE) + 1; // get last page No (zero based)
        else
            lastPage = (int) (totalTours / PAGE_SIZE);
        model.addAttribute("currPage", page);
        model.addAttribute("lastPage", lastPage);
        String sortField;
        if (sortedType != null) {
            switch (sortedType) {
                case "1":
                    sortField = "dateOfDeparture";
                    break;
                case "2":
                    sortField = "discountPrice";
                    break;
                case "3":
                    sortField = "numberOfNights";
                    break;
                default:
                    sortField = "id";
            }
        } else {
            sortField = "id";
        }

        Page<Tour> tours = tourRepository.findAll(PageRequest.of(Integer.parseInt(page), PAGE_SIZE, Sort.by(Sort.Direction.ASC, sortField)));
        model.addAttribute("tours", tours.getContent());
        model.addAttribute("sortedValue", sortedType == null ? 0 : sortedType);
        model.addAttribute("sortedParam", "?sortedType=" + (sortedType == null ? 0 : sortedType));
        return "tours";
    }

    @GetMapping("tour/{id}")
    public String TourDetails(@PathVariable long id, Model model) {
        model.addAttribute("tour", tourService.getTourById(id));
        return "tourDetails";
    }

    @GetMapping("/hot/{id}")
    public String updateTour(@PathVariable long id, Model model) {
        model.addAttribute("discounts", DiscountType.values());
        model.addAttribute("tour", tourService.getTourById(id));
        return "hotTour";
    }

    @PostMapping("/hotTour")
    public String setHotTour(@ModelAttribute("tour") Tour hotTour, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addTour";
        }
        Tour tour = tourService.getTourById(hotTour.getId());
        tour.setDiscount(hotTour.getDiscount());
        tourService.updateTour(tour);
        return "redirect:/tours";
    }

}
