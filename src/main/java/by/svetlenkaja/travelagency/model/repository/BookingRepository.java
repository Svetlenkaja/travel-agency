package by.svetlenkaja.travelagency.model.repository;

import by.svetlenkaja.travelagency.model.entity.Booking;
import by.svetlenkaja.travelagency.model.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query(value = "select count(b.id) from booking b where client_id = :clientId and b.status_code = 2", nativeQuery = true)
    long getCountPaidBookingByClientId(long clientId);

    @Query(value = "select b.* from tour t inner join booking b on t.id = b.tour_id where b.client_id = :userId", nativeQuery = true)
    List<Booking> findBookingsByUser(long userId);
}
