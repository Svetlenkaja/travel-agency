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
import java.util.List;
import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(TourServiceImpl.class);

    @Override
    public Booking bookTour(Tour tour, User user) {
        final Random RANDOM = new Random();
        //count paid tours of client
        long bookingCount = bookingRepository.getCountPaidBookingByClientId(user.getId());
        Booking booking = new Booking();
        booking.setOrderNumber(RANDOM.nextInt(1000) + "_" + "22");
        booking.setClient(user);
        booking.setTour(tour);
        booking.setStatusType(ClassifierType.BOOKING_STATUS.getType());
        booking.setStatusCode(BookingStatusType.OPENED.getCode());
        //sale
        double costWithSale = bookingCount > 0 ? tour.getCostWithDiscount() - (tour.getCostWithDiscount() * bookingCount / 100) : tour.getCostWithDiscount();
        booking.setCostWithSale(costWithSale);
        return bookingRepository.save(booking);

    }

    @Override
    public List<Booking> getBookingsByUser(User user) {
        return bookingRepository.findBookingsByUser(user.getId());
    }

    @Override
    public Booking getBookingById(long id) {
        try {
            return bookingRepository.getById(id);
        } catch (EntityNotFoundException e) {
            throw e;
        }
    }

    @Override
    public Payment addPayment(Payment payment) {
        Booking booking = getBookingById(payment.getBooking().getId());
        payment.setBooking(booking);
        if (booking.getStatusCode() == BookingStatusType.OPENED.getCode()) {
            Tour tour = booking.getTour();
            if (tour.getStateType().equals(new Classifier(ClassifierType.STATE.getType(), StateType.CANCELLED.getCode()))) {
                throw new BookingServiceException("Тур отменен. Оплата невозможна!!!");
            }
            if (tour.getStateType().equals(new Classifier(ClassifierType.STATE.getType(), StateType.PAID.getCode()))) {
                throw new BookingServiceException("Тур уже оплачен ранее!!!");
            }
            try {
                payment.getBooking().setStatusCode(BookingStatusType.PAID.getCode());
                payment.getBooking().getTour().setStateType(new Classifier(ClassifierType.STATE.getType(), StateType.PAID.getCode()));
                paymentRepository.saveAndFlush(payment);
                return payment;
            } catch (RuntimeException e) {
                LOGGER.error("Error add tour with data: {}", payment.toString());
                throw new BookingServiceException("Произошла ошибка при оплате заказа. Обратитесь к администратору.");
            }
        } else {
            throw new BookingServiceException("Невозможно оплатить данный заказ.");
        }
    }

    @Override
    public List<Booking> getBookingsNotClosed() {
        return bookingRepository.findBookingsNotClosed();
    }
}
