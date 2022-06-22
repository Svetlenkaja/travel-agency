package by.svetlenkaja.travelagency.service.impl;

import by.svetlenkaja.travelagency.constant.BookingStatusType;
import by.svetlenkaja.travelagency.constant.ClassifierType;
import by.svetlenkaja.travelagency.model.entity.Booking;
import by.svetlenkaja.travelagency.model.entity.Tour;
import by.svetlenkaja.travelagency.model.entity.User;
import by.svetlenkaja.travelagency.model.repository.BookingRepository;
import by.svetlenkaja.travelagency.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public Booking bookTour(Tour tour, User user) {
        final Random RANDOM = new Random();
        long bookingCount = bookingRepository.getCountPaidBookingByClientId(user.getId());
        Booking booking = new Booking();
        booking.setOrderNumber(RANDOM.nextInt(1000) + "_" + "22");
        booking.setClient(user);
        booking.setTour(tour);
        booking.setStatusType(ClassifierType.BOOKING_STATUS.getType());
        booking.setStatusCode(BookingStatusType.OPENED.getCode());
        booking.setCost(tour.getCostWithDiscount());
        double discount = bookingCount > 0 ? tour.getCostWithDiscount() - (tour.getCostWithDiscount() * bookingCount / 100) : tour.getCostWithDiscount();
        booking.setDiscount(discount);
        return bookingRepository.save(booking);

    }

    @Override
    public List<Booking> getBookingsByUser(User user) {
        return bookingRepository.findBookingsByUser(user.getId());
    }
}
