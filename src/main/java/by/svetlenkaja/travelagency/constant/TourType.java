package by.svetlenkaja.travelagency.constant;

import by.svetlenkaja.travelagency.model.entity.Classifier;

import java.util.stream.Stream;

public enum TourType {
    REST(1),
    EXCURSION(2),
    THERAPY(3);

    final int code;
    private Classifier classifier;

    TourType(int code) {
        this.code = code;
        this.classifier = new Classifier();
    }

    public int getCode() {
        return code;
    }

    public void setClassifier(Classifier classifier) {
        this.classifier = classifier;
    }

    public Classifier getClassifier() {
        return classifier;
    }

    public static TourType of(int code){
        return Stream.of(TourType.values())
                .filter(t -> t.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}