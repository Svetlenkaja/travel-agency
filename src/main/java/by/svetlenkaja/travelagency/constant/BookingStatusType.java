package by.svetlenkaja.travelagency.constant;

import by.svetlenkaja.travelagency.model.entity.Classifier;

import java.util.stream.Stream;

public enum BookingStatusType {
    OPENED(1),
    PAID(2),
    CLOSED(3),
    CANCELLED(4);

    final int code;
    private Classifier classifier;

    BookingStatusType(int code) {
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

    public static BookingStatusType of(int code){
        return Stream.of(BookingStatusType.values())
                .filter(t -> t.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
