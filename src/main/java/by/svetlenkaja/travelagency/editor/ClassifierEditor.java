package by.svetlenkaja.travelagency.editor;

import by.svetlenkaja.travelagency.constant.TypeClassifier;
import by.svetlenkaja.travelagency.model.entity.Classifier;
import org.springframework.stereotype.Component;


import java.beans.PropertyEditorSupport;

public class ClassifierEditor extends PropertyEditorSupport {

    final int typeClassifier;

    public ClassifierEditor(int typeClassifier) {
        this.typeClassifier = typeClassifier;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        setValue(new Classifier(typeClassifier, Integer.parseInt(text)));
    }
}
