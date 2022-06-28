package by.svetlenkaja.travelagency.constant;

public enum DiscountType {
    DISCOUNT_0(0),
    DISCOUNT_10(10),
    DISCOUNT_15(15),
    DISCOUNT_20(20),
    DISCOUNT_25(25),
    DISCOUNT_30(30);

    final int code;

    DiscountType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
