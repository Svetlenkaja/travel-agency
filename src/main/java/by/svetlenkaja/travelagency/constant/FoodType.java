package by.svetlenkaja.travelagency.constant;

import java.util.stream.Stream;

public enum FoodType {
    RO(1, "RO", "room only"),
    BB(2, "BB", "bed & breakfast"),
    HB(3, "HB","half board"),
    FB(4, "FB", "full board"),
    AI(5, "AI", "All inclusive"),
    UAI(6, "UAI", "ultra all inclusive");

    private final int code;
    private final String name;
    private final String fullName;


    FoodType(int code, String name, String fullName)  {
        this.code = code;
        this.name = name;
        this.fullName = fullName;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public static FoodType of(int code){
        return Stream.of(FoodType.values())
                .filter(t -> t.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

//    public static String  getFoodTypeFullName(FoodType foodType) {
//        return foodType.getFullName();
//    }
}
