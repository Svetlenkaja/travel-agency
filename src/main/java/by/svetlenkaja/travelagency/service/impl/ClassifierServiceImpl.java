package by.svetlenkaja.travelagency.service.impl;

import by.svetlenkaja.travelagency.constant.ClassifierType;
import by.svetlenkaja.travelagency.model.entity.Classifier;
import by.svetlenkaja.travelagency.model.repository.ClassifierRepository;
import by.svetlenkaja.travelagency.service.ClassifierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ClassifierServiceImpl implements ClassifierService {

    private final ClassifierRepository classifierRepository;

    @Override
    public List<Classifier> getTourTypes() {
        return classifierRepository.findByType(ClassifierType.TOUR.getType());
    }

    @Override
    public Classifier getTourTypeClassifier(int type, int code) {
        return classifierRepository.findByTypeAndCode(type, code);
    }

    @Override
    public List<Classifier> getFoodTypes() {
        return classifierRepository.findByType(ClassifierType.FOOD.getType());
    }

    @Override
    public List<Classifier> getTransportTypes() {
        return classifierRepository.findByType(ClassifierType.TRANSPORT.getType());
    }

    @Override
    public List<Classifier> getRoles() {
        return classifierRepository.findByType(ClassifierType.ROLE.getType());
    }
}
