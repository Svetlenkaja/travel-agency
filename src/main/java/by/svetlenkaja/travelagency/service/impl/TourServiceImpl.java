package by.svetlenkaja.travelagency.service.impl;

import by.svetlenkaja.travelagency.exception.TourServiceException;
import by.svetlenkaja.travelagency.model.entity.Hotel;
import by.svetlenkaja.travelagency.model.entity.Tour;
import by.svetlenkaja.travelagency.model.repository.TourRepository;
import by.svetlenkaja.travelagency.service.TourService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(TourServiceImpl.class);

    @Override
    public List<Tour> getAll() {
        return tourRepository.findAll();
    }

    @Override
    public Tour addTour(Tour tour) {
        try {
            return tourRepository.save(tour);
        }
        catch (RuntimeException e){
     //       LOGGER.error("Error add tour with data: {}", tour.toString());
            throw new TourServiceException("Ошибка сохранения тура. Обратитесь к администратору.");
        }
    }

    @Override
    public Tour getTourById(long id) {
        return tourRepository.getById(id);
    }

    @Override
    public Hotel getHotelById(long id) {
        return null;
    }
}
