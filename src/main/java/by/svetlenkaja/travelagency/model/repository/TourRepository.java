package by.svetlenkaja.travelagency.model.repository;

import by.svetlenkaja.travelagency.model.entity.Hotel;
import by.svetlenkaja.travelagency.model.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

}
