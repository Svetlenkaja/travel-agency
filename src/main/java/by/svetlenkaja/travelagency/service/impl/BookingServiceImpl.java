package by.svetlenkaja.travelagency.service.impl;

import by.svetlenkaja.travelagency.constant.BookingStatusType;
import by.svetlenkaja.travelagency.constant.ClassifierType;
import by.svetlenkaja.travelagency.constant.StateType;
import by.svetlenkaja.travelagency.exception.BookingServiceException;
import by.svetlenkaja.travelagency.exception.TourServiceException;
import by.svetlenkaja.travelagency.model.entity.*;
import by.svetlenkaja.travelagency.model.repository.BookingRepository;
import by.svetlenkaja.travelagency.model.repository.PaymentRepository;
import by.svetlenkaja.travelagency.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service

@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(TourServiceImpl.class);

    @Transactional
    @Override
    public Booking bookTour(Tour tour, User user) {
        //count paid tours of client
        long bookingCount = bookingRepository.getCountPaidBookingByClientId(user.getId());
        //количество заказов в году
        long nextOrderNumber = bookingRepository.findBookingsByYear(LocalDate.now().getYear()) + 1;
        Booking booking = new Booking()
                .setOrderNumber(nextOrderNumber + "_" + LocalDate.now().getYear())
                .setClient(user)
                .setTour(tour)
                .setStatus(BookingStatusType.OPENED);
        //sale
        double totalCost = bookingCount > 0 ? tour.getDiscountPrice() - (tour.getDiscountPrice() * bookingCount / 100) : tour.getDiscountPrice();
        booking.setTotalCost(totalCost);
        booking.getTour().setState(StateType.BOOKED);
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByUser(User user) {
        return bookingRepository.findBookingsByUser(user.getId());
    }

    @Override
    public Booking getBookingById(long id) {
        return bookingRepository.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public Payment addPayment(Payment payment) {
        Booking booking = getBookingById(payment.getBooking().getId());
        payment.setBooking(booking);
        bookingIsValidate(booking);
        try {
            updateStateBookingAndTour(payment);
            paymentRepository.save(payment);
            return payment;
        } catch (RuntimeException e) {
            LOGGER.error("Error add tour with data: {}", payment.toString());
            throw new BookingServiceException("Произошла ошибка при оплате заказа. Обратитесь к администратору.");
        }
    }

    private void updateStateBookingAndTour(Payment payment) {
        payment.getBooking().setStatusCode(BookingStatusType.PAID.getCode());
        payment.getBooking().getTour().setStateCode(StateType.PAID.getCode());
    }

    private void bookingIsValidate(Booking booking) {
        if (booking.getStatusCode() != BookingStatusType.OPENED.getCode()) {
            throw new BookingServiceException("Невозможно оплатить данный заказ.");
        }
        Tour tour = booking.getTour();
        if (tour.getState().equals(StateType.CANCELLED)) {
            throw new BookingServiceException("Тур отменен. Оплата невозможна!!!");
        }
        if (tour.getState().equals(StateType.PAID)) {
            throw new BookingServiceException("Тур уже оплачен ранее!!!");
        }
    }

    @Override
    public List<Booking> getBookingsNotClosed() {
        return bookingRepository.findBookingsNotClosed();
    }
}
