package by.svetlenkaja.travelagency.editor;

import by.svetlenkaja.travelagency.model.entity.Classifier;


import java.beans.PropertyEditorSupport;

public class ClassifierEditor extends PropertyEditorSupport {

    int typeClassifier;

    public ClassifierEditor(int typeClassifier) {
        this.typeClassifier = typeClassifier;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
//        try {
//            String[] words = text.split("|");
//            setValue(new Classifier(Integer.parseInt(words[0]), Integer.parseInt(words[1])));
//        }
//        catch (NumberFormatException e)
//        {
//            setValue(new Classifier(0, 0));
//        }
        setValue(new Classifier(typeClassifier, Integer.parseInt(text)));
    }
}
