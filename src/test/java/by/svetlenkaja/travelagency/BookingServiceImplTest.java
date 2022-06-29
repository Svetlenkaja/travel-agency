package by.svetlenkaja.travelagency;

import by.svetlenkaja.travelagency.constant.BookingStatusType;
import by.svetlenkaja.travelagency.constant.StateType;
import by.svetlenkaja.travelagency.exception.BookingServiceException;
import by.svetlenkaja.travelagency.model.entity.Booking;
import by.svetlenkaja.travelagency.model.entity.Payment;
import by.svetlenkaja.travelagency.model.entity.Tour;
import by.svetlenkaja.travelagency.model.entity.User;
import by.svetlenkaja.travelagency.model.repository.BookingRepository;
import by.svetlenkaja.travelagency.model.repository.PaymentRepository;
import by.svetlenkaja.travelagency.model.repository.TourRepository;
import by.svetlenkaja.travelagency.service.TourService;
import by.svetlenkaja.travelagency.service.impl.BookingServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.time.LocalDate;
import java.util.Optional;

public class BookingServiceImplTest {

    private User user;
    @Spy
    BookingRepository bookingRepository;

    @Spy
    PaymentRepository paymentRepository;

    @Spy
    TourService tourService;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setId(1L);
    }

    @Test
    void successSaveBooking(){
        Tour tour = new Tour()
                .setState(StateType.AVAILABLE);
        tour.setId(1L);
        Mockito.when(tourService.getTourById(1L)).thenReturn(tour);
        Mockito.when(bookingRepository.findBookingsByYear(LocalDate.now().getYear())).thenReturn(0L);
        long nextOrderNumber = 1L;
        Booking booking = new Booking()
                .setTour(tour)
                .setClient(user)
                .setOrderNumber(nextOrderNumber + "_" + LocalDate.now().getYear())
                .setStatus(BookingStatusType.OPENED);

        Mockito.when(bookingRepository.getCountPaidBookingByClientId(user.getId())).thenReturn(0L);

        bookingService.makeBooking(1L, user);
        Mockito.verify(bookingRepository, Mockito.times(1)).findBookingsByYear(LocalDate.now().getYear());
        Mockito.verify(bookingRepository, Mockito.times(1)).save(booking);
    }

    @Test
    void errorSaveBookingWrongState() {
        Tour tour = new Tour()
                .setState(StateType.BOOKED);
        Mockito.when(tourService.getTourById(1L)).thenReturn(tour);

        String actualExceptionMessage = Assertions.assertThrows(BookingServiceException.class, () -> {
            bookingService.makeBooking(1L, user);
        }).getMessage();

        String expectedExceptionMessage = "Этот тур недоступен к заказу";
        Assertions.assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    void errorSaveBookingNotFoundTour() {
        Mockito.when(tourService.getTourById(1L)).thenReturn(null);

        String actualExceptionMessage = Assertions.assertThrows(BookingServiceException.class, () -> {
            bookingService.makeBooking(1L, user);
        }).getMessage();

        String expectedExceptionMessage = "Тур не найден!";
        Assertions.assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }

    @Test
    void successSetStateTour(){
        Tour tour = new Tour()
                .setState(StateType.AVAILABLE);
        Mockito.when(tourService.getTourById(1L)).thenReturn(tour);
        bookingService.makeBooking(1L, user);
        Assertions.assertEquals(StateType.BOOKED, tour.getState());
    }

    @Test
    void getBookingById(){
        Booking expectedBooking = new Booking();
        Mockito.when(bookingRepository.findById(1L)).thenReturn(Optional.of(expectedBooking));

        Booking actualBooking = bookingService.getBookingById(1L);
        Assertions.assertEquals(expectedBooking, actualBooking);
    }

//    @Test
//    void successSavePayment(){
//        Booking booking = new Booking().setId(1L);
//        Mockito.when(bookingService.getBookingById(1L)).thenReturn(booking);
//        Payment payment = new Payment()
//                .setId(1L)
//                .setBooking(booking);
//        bookingService.savePayment(payment);
//        Mockito.verify(paymentRepository, Mockito.times(1)).save(payment);
//    }
}
