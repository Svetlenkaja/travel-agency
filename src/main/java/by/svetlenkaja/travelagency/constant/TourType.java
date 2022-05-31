package by.svetlenkaja.travelagency.constant;

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
}