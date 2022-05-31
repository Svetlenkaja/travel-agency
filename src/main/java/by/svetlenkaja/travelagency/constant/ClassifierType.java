package by.svetlenkaja.travelagency.constant;

public enum ClassifierType {
    ROLE(2),
    TOUR(3),
    TRANSPORT(4),
    FOOD(5),
    STATE(6),
    CLASS_HOTEL(7),
    KIND_EXCURSION(8),
    THERAPY(9),
    ROOM_TYPE(10);

    final int type;

    ClassifierType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
