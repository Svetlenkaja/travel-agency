package by.svetlenkaja.travelagency.constant;

public enum RoleType {
    ADMIN(1),
    MANAGER(2),
    CLIENT(3);

    final int code;

    RoleType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
