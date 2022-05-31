package by.svetlenkaja.travelagency.constant;

public enum RoomType {
    SINGLE(1),
    DOUBLE(2),
    TRIPLE(3);

    final int code;

    RoomType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
