package by.svetlenkaja.travelagency.controller;

import by.svetlenkaja.travelagency.model.entity.Booking;
import by.svetlenkaja.travelagency.model.entity.Payment;
import by.svetlenkaja.travelagency.model.entity.User;
import by.svetlenkaja.travelagency.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @GetMapping("/{id}")
    public String openBooking(@PathVariable long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            User user = (User) auth.getPrincipal();
            bookingService.makeBooking(id, user);
            return "redirect:myBooking";
        }
        return "403";
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
        bookingService.savePayment(payment);
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
    public String cancelBooking(@PathVariable (name="bookingId") long bookingId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            User user = (User) auth.getPrincipal();
            bookingService.bookingCanceled(bookingId, user);
            return "redirect:myBooking";
        }
        return "403";
    }
}
