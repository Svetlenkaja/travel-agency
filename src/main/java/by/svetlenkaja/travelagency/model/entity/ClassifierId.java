package by.svetlenkaja.travelagency.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class ClassifierId implements Serializable {

    private int type;
    private int code;

    public ClassifierId(){
    }

    public ClassifierId(int type, int code) {
        this.type = type;
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassifierId that = (ClassifierId) o;
        return type == that.type && code == that.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, code);
    }
}
