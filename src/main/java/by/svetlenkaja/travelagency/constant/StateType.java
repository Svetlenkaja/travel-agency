package by.svetlenkaja.travelagency.constant;

public enum StateType {
    AVAILABLE(1,"Доступен"),
    HOT(2, "Горящий"),
    BOOKED(3, "Забронирован"),
    PAID(4, "Оплачен"),
    CANCELLED(5, "Отменен");

    final int code;
    final String name;

    StateType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public static String getName(StateType stateType) {
        return stateType.getName();
    }
}
