package by.svetlenkaja.travelagency.service.impl;

import by.svetlenkaja.travelagency.constant.TypeClassifier;
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
        return classifierRepository.findByType(TypeClassifier.TOUR.getType());
    }

    @Override
    public Classifier getTourTypeClassifier(int type, int code) {
        return classifierRepository.findByTypeAndCode(type, code);
    }

    @Override
    public List<Classifier> getFoodTypes() {
        return classifierRepository.findByType(TypeClassifier.FOOD.getType());
    }

    @Override
    public List<Classifier> getTransportTypes() {
        return classifierRepository.findByType(TypeClassifier.TRANSPORT.getType());
    }

    @Override
    public List<Classifier> getRoles() {
        return classifierRepository.findByType(TypeClassifier.ROLE.getType());
    }
}
