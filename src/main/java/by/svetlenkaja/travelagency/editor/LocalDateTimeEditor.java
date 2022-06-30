package by.svetlenkaja.travelagency.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String value) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            setValue(LocalDateTime.parse(value, formatter));
        } catch (Exception ex) {
            setValue(null);
        }
    }
}
