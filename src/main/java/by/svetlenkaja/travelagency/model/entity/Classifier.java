package by.svetlenkaja.travelagency.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(ClassifierId.class)
public class Classifier {
    @Id
    private int type;

    @Id
    private int code;

    @Column
    private String name;

    @Column
    private String shortname;
}
