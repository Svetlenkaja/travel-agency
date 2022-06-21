package by.svetlenkaja.travelagency.service;

import by.svetlenkaja.travelagency.model.entity.Booking;

public interface BookingService {
    Booking bookTour(long tourId, long clientId);

    long getCountPaidBookingByClientId(long clientId);
}
