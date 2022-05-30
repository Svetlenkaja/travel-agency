package by.svetlenkaja.travelagency.constant;

public enum TransportType {
    AIRPLANE("Самолет"), TRAIN("Поезд"), BUS("Автобус"), SHIP("Лайнер");

    String name;

    TransportType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getName(TransportType transportType ) {
        return transportType.getName();
    }
}
