package by.svetlenkaja.travelagency.service;

import by.svetlenkaja.travelagency.model.entity.Booking;
import by.svetlenkaja.travelagency.model.entity.Tour;
import by.svetlenkaja.travelagency.model.entity.User;

import java.util.List;

public interface BookingService {
    Booking bookTour(Tour tour, User user);
    List<Booking> getBookingsByUser(User user);
}
