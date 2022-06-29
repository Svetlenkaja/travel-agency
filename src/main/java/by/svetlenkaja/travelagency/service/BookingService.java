package by.svetlenkaja.travelagency.service;

import by.svetlenkaja.travelagency.model.entity.Booking;
import by.svetlenkaja.travelagency.model.entity.Payment;
import by.svetlenkaja.travelagency.model.entity.User;

import java.util.List;

public interface BookingService {
    Booking makeBooking(long id, User user);
    List<Booking> getBookingsByUser(User user);
    Booking getBookingById(long id);
    Payment savePayment(Payment payment);
    List<Booking> getBookingsNotClosed();
    void bookingCanceled(long id, User user);
}
