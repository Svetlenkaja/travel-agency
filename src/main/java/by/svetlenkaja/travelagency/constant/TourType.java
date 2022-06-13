package by.svetlenkaja.travelagency.constant;

import by.svetlenkaja.travelagency.model.entity.Classifier;

import java.util.stream.Stream;

public enum TourType {
    REST(1,"Отдых"),
    EXCURSION(2, "Экскурссия"),
    THERAPY(3,"Оздоровление");

    final int code;
    final String name;

    TourType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getName(TourType tourType) {
        return tourType.getName();
    }

    public int getCode() {
        return code;
    }

    public static TourType of(int code){
        return Stream.of(TourType.values())
                .filter(t -> t.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}