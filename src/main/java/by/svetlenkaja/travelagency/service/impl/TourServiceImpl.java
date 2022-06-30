package by.svetlenkaja.travelagency.service.impl;

import by.svetlenkaja.travelagency.constant.StateType;
import by.svetlenkaja.travelagency.exception.TourServiceException;
import by.svetlenkaja.travelagency.model.entity.Tour;
import by.svetlenkaja.travelagency.model.repository.TourRepository;
import by.svetlenkaja.travelagency.service.TourService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
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

    @Transactional
    @Override
    public Tour addTour(Tour tour) {
        tourIsValidate(tour);
        tour.setState(StateType.AVAILABLE);
        costCalculation(tour);
        try {
            return tourRepository.save(tour);
        }
        catch (RuntimeException e){
            LOGGER.error("Error add tour with data: {}", tour.toString());
            throw new TourServiceException("Произошла ошибка при сохранении тура. Обратитесь к администратору!");
        }
    }

    private void costCalculation(Tour tour) {
        if (tour.getDiscount() > 0) {
            tour.setDiscountPrice(tour.getPrice() * (1 - (double)tour.getDiscount()/100));
        } else {
            tour.setDiscountPrice(tour.getPrice());
        }
    }

    private void tourIsValidate(Tour tour) {
        if (tour.getType() == null) {
            throw new TourServiceException("Не выбран тип тура!");
        }
        if (tour.getPrice() <= 0){
            throw new TourServiceException("Стоимость тура должна быть больше 0!");
        }
        if (tour.getNumberOfNights() <= 0) {
            throw new TourServiceException("Количество ночей должно быть больше 0!");
        }
    }

    @Override
    public Tour getTourById(long id) {
        return tourRepository.findById(id).orElse(null);
    }

    @Override
    public Tour updateTour(Tour tour) {
        tour.setStateCode(StateType.HOT.getCode());
        costCalculation(tour);
        try {
            return tourRepository.save(tour);
        }
        catch (RuntimeException e){
            LOGGER.error("Error add tour with data: {}", tour.toString());
            throw new TourServiceException("Ошибка сохранения тура. Обратитесь к администратору.");
        }
    }
}
