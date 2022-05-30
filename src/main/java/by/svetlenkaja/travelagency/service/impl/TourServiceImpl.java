package by.svetlenkaja.travelagency.service.impl;

import by.svetlenkaja.travelagency.model.entity.RestTour;
import by.svetlenkaja.travelagency.model.entity.Tour;
import by.svetlenkaja.travelagency.model.repository.TourRepository;
import by.svetlenkaja.travelagency.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    @Override
    public List<Tour> getAll() {
        return tourRepository.findAll();
    }

    @Override
    public RestTour addRestTour(RestTour tour) {
        return tourRepository.save(tour);
    }
}
