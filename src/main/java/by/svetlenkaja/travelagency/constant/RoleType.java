package by.svetlenkaja.travelagency.constant;

public enum RoleType {
    ROLE_ADMIN(1),
    ROLE_MANAGER(2),
    ROLE_CLIENT(3);

    final int code;

    RoleType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
