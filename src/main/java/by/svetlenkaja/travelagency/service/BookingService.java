package by.svetlenkaja.travelagency.service;

import by.svetlenkaja.travelagency.model.entity.Booking;
import by.svetlenkaja.travelagency.model.entity.Tour;
import by.svetlenkaja.travelagency.model.entity.User;

public interface BookingService {
    Booking bookTour(Tour tour, User user);

}
