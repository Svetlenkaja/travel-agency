package by.svetlenkaja.travelagency.service.impl;

import by.svetlenkaja.travelagency.model.entity.Classifier;
import by.svetlenkaja.travelagency.model.repository.ClassifierRepository;
import by.svetlenkaja.travelagency.service.ClassifierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ClassifierServiceImpl implements ClassifierService {

    private final ClassifierRepository classifierRepository;
    @Override
    public Iterable<Classifier> getTourType() {

        return classifierRepository.findAll();
    }
}
