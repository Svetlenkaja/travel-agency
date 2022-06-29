package by.svetlenkaja.travelagency.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String value) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            setValue(LocalDate.parse(value, formatter));
        } catch (Exception ex) {
            setValue(null);
        }
    }
}
