package by.svetlenkaja.travelagency.constant;

public enum FoodType {
    RO(1, "RO", "room only"),
    BB(2, "BB", "bed & breakfast"),
    HB(3, "HB","half board"),
    FB(4, "FB", "full board"),
    AI(5, "AI", "All inclusive"),
    UAI(6, "UAI", "ultra all inclusive");

    private final int code;
    private final String shortName;
    private final String fullName;


    FoodType(int code, String shortName, String fullName)  {
        this.code = code;
        this.shortName = shortName;
        this.fullName = fullName;
    }

    public int getCode() {
        return code;
    }

    public String getFullName() {
        return fullName;
    }

//    public static String  getFoodTypeFullName(FoodType foodType) {
//        return foodType.getFullName();
//    }
}
