package by.svetlenkaja.travelagency.service;

import by.svetlenkaja.travelagency.model.entity.Hotel;
import by.svetlenkaja.travelagency.model.entity.Tour;
import by.svetlenkaja.travelagency.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TourService {
    List<Tour> getAll();

    Tour addTour(Tour tour);

    Tour getTourById(long id);

}
