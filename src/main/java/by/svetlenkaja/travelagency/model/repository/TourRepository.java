package by.svetlenkaja.travelagency.model.repository;

import by.svetlenkaja.travelagency.model.entity.Country;
import by.svetlenkaja.travelagency.model.entity.Hotel;
import by.svetlenkaja.travelagency.model.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    @Query(value = "from Country")
    List<Country> getCountries ();
}
