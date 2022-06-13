package by.svetlenkaja.travelagency.constant;

import java.util.stream.Stream;

public enum TransportType {
    AIRPLANE(1,"Самолет"),
    TRAIN(2,"Поезд"),
    BUS(3,"Автобус"),
    SHIP(4, "Лайнер");

    final int code;
    final String name;

    TransportType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getName(TransportType transportType ) {
        return transportType.getName();
    }

    public static TransportType of(int code){
        return Stream.of(TransportType.values())
                .filter(t -> t.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
