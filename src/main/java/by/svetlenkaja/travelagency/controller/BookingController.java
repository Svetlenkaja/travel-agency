package by.svetlenkaja.travelagency.controller;

import by.svetlenkaja.travelagency.model.entity.Booking;
import by.svetlenkaja.travelagency.model.entity.Payment;
import by.svetlenkaja.travelagency.model.entity.Tour;
import by.svetlenkaja.travelagency.model.entity.User;
import by.svetlenkaja.travelagency.service.BookingService;
import by.svetlenkaja.travelagency.service.TourService;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final TourService tourService;

    @GetMapping("/{id}")
    public String openBooking(@PathVariable long id){
        Tour tour = tourService.getTourById(id);
        bookingService.bookTour(tour, (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "redirect:myBooking";
    }

    @GetMapping("/myBooking")
    public String PersonalTours(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            User user = (User) auth.getPrincipal();
            model.addAttribute("booking", bookingService.getBookingsByUser(user));
            return "myBooking";
        }
        return "403";
    }

    @GetMapping("/payment/{bookingId}")
    public String createPayment(@PathVariable (name="bookingId") long bookingId, Model model){
        Booking booking = bookingService.getBookingById(bookingId);
        Payment payment = new Payment(booking);
        model.addAttribute("payment", payment);
        return "payment";
    }

    @PostMapping("/addPayment")
    public String addPayment(@ModelAttribute ("payment") Payment payment,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()){
            return "addTour";
        }
        bookingService.addPayment(payment);
        return "redirect:myBooking";
    }

    @GetMapping("")
    public String bookings(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            User user = (User) auth.getPrincipal();
            model.addAttribute("bookings", bookingService.getBookingsNotClosed());
            return "bookings";
        }
        return "403";
    }

    @GetMapping("/cancel/{bookingId}")
    public String cancelBooking(@PathVariable (name="bookingId") long bookingId, Model model){
        //TODO
        Booking booking = bookingService.getBookingById(bookingId);
        return "bookings";
    }
}
