package by.svetlenkaja.travelagency.service;

import by.svetlenkaja.travelagency.model.entity.RestTour;
import by.svetlenkaja.travelagency.model.entity.Tour;

import java.util.List;

public interface TourService {
    List<Tour> getAll();
    RestTour addRestTour(RestTour tour);
}
