package by.svetlenkaja.travelagency.constant;

import by.svetlenkaja.travelagency.model.entity.Classifier;

import java.util.stream.Stream;

public enum FoodType {
    RO(1),
    BB(2),
    HB(3),
    FB(4),
    AI(5),
    UAI(6);

    private final int code;
    private Classifier classifier;

    FoodType(int code)  {
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

    public static FoodType of(int code){
        return Stream.of(FoodType.values())
                .filter(t -> t.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
