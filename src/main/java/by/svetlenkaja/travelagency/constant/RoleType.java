package by.svetlenkaja.travelagency.constant;

public enum RoleType {
    ROLE_ADMIN(1, "ADMIN"),
    ROLE_MANAGER(2, "MANAGER"),
    ROLE_CLIENT(3, "CLIENT");

    final int code;
    final String name;

    RoleType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
