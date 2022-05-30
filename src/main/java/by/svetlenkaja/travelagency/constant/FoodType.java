package by.svetlenkaja.travelagency.constant;

public enum FoodType {
    RO("RO", "room only", 1),
    BB("BB", "bed & breakfast", 2),
    HB("HB","half board", 3),
    FB("FB", "full board", 4),
    AI("AI", "All inclusive", 5),
    UAI("UAI", "ultra all inclusive", 6);

    private final String shortName;
    private final String fullName;
    private final int rankCost;

    FoodType(String shortName, String fullName, int rankCost) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.rankCost = rankCost;
    }

    public String getFullName() {
        return fullName;
    }

    public static String  getFoodTypeFullName(FoodType foodType) {
        return foodType.getFullName();
    }
}
