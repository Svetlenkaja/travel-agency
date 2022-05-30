package by.svetlenkaja.travelagency.constant;

public enum TypeClassifier {
    ROLE(2),
    TOUR(3),
    TRANSPORT(4),
    FOOD(5),
    STATE(6);

    final int type;

    TypeClassifier(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
