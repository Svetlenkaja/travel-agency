package by.svetlenkaja.travelagency.service;

import by.svetlenkaja.travelagency.model.entity.Classifier;

import java.util.List;

public interface ClassifierService {
    List<Classifier> getTourTypes();

    Classifier getTourTypeClassifier(int type, int code);

    List<Classifier> getFoodTypes();

    List<Classifier> getTransportTypes();

    List<Classifier> getRoles();

}
