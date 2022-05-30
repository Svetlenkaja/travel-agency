package by.svetlenkaja.travelagency.model;

import by.svetlenkaja.travelagency.model.entity.Classifier;
import by.svetlenkaja.travelagency.service.impl.ClassifierServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TourTypeTest {

    static ClassifierServiceImpl classifierService;

    public static Classifier loadFromDB(int type, int code) {
        return classifierService.getTourTypeClassifier(type, code);
    }

    public enum TType {
        REST(loadFromDB(3, 1)),
        EXCURSION(loadFromDB(3, 2)),
        THERAPY(loadFromDB(3, 3));

        final Classifier classifier;

        TType(Classifier classifier) {
            this.classifier = classifier;
        }
    }
}
