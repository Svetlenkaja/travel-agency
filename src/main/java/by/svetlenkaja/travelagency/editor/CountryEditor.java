package by.svetlenkaja.travelagency.editor;

import by.svetlenkaja.travelagency.model.entity.Country;

import java.beans.PropertyEditorSupport;

public class CountryEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        //      super.setAsText(text);
        setValue(new Country(Integer.parseInt(text)));
    }
}
