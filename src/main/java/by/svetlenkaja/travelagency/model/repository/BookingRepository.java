package by.svetlenkaja.travelagency.model.repository;

import by.svetlenkaja.travelagency.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query(value = "select count(b.id) from booking b where client_id = :clientId and b.status_code = 2", nativeQuery = true)
    long getCountPaidBookingByClientId(long clientId);
}
