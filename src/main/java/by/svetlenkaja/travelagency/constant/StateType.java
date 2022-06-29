package by.svetlenkaja.travelagency.constant;

import by.svetlenkaja.travelagency.model.entity.Classifier;

import java.util.stream.Stream;

public enum StateType {
    AVAILABLE(1),
    HOT(2 ),
    BOOKED(3),
    PAID(4),
    CANCELLED(5);

    final int code;
    private Classifier classifier;

    StateType(int code ) {
        this.code = code;
        this.classifier = new Classifier();
    }

    public void setClassifier(Classifier classifier) {
        this.classifier = classifier;
    }

    public Classifier getClassifier() {
        return classifier;
    }

    public int getCode() {
        return code;
    }

    public static StateType of(int code) {
        return Stream.of(StateType.values())
                .filter(t -> t.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
