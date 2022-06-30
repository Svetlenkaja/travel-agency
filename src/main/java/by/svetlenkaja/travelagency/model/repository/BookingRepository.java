package by.svetlenkaja.travelagency.model.repository;

import by.svetlenkaja.travelagency.model.entity.Booking;
import by.svetlenkaja.travelagency.model.entity.Tour;
import by.svetlenkaja.travelagency.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "select count(b.id) from booking b where client_id = :clientId and b.status_code = 2", nativeQuery = true)
    long getCountPaidBookingByClientId(long clientId);

    @Query(value = "select b.* from booking b where b.client_id = :userId and b.status_code <> 4", nativeQuery = true)
    List<Booking> findBookingsByUser(long userId);

    @Query(value = "select * from booking b where b.status_code in (1, 2)", nativeQuery = true)
    List<Booking> findBookingsNotClosed();

    @Query(value = "select count(*) from booking b where YEAR(b.order_date) = :year", nativeQuery = true)
    long findBookingsByYear(long year);

    Booking findBookingByIdAndClient(long id, User user);
}
