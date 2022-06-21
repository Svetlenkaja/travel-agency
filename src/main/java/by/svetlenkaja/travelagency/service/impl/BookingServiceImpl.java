package by.svetlenkaja.travelagency.service.impl;

import by.svetlenkaja.travelagency.model.entity.Booking;
import by.svetlenkaja.travelagency.model.repository.BookingRepository;
import by.svetlenkaja.travelagency.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public Booking bookTour(long tourId, long userId) {
        return null;
    }

    @Override
    public long getCountPaidBookingByClientId(long clientId) {
        return 0;
    }
}
