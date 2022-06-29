package by.svetlenkaja.travelagency.service;

import by.svetlenkaja.travelagency.model.entity.Booking;
import by.svetlenkaja.travelagency.model.entity.Payment;
import by.svetlenkaja.travelagency.model.entity.Tour;
import by.svetlenkaja.travelagency.model.entity.User;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface BookingService {
    Booking bookTour(Tour tour, User user);
    List<Booking> getBookingsByUser(User user);
    Booking getBookingById(long Id);
    Payment addPayment(Payment payment);
    List<Booking> getBookingsNotClosed();
}
