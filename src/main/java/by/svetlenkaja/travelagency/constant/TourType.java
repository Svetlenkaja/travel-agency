package by.svetlenkaja.travelagency.constant;

public enum TourType {
    REST("Отдых"),
    EXCURSION("Экскурссия"),
    THERAPY("Оздоровление");

    final String name;

    TourType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getName(TourType tourType) {
        return tourType.getName();
    }
}