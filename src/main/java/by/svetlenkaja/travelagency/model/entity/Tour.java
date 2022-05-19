package by.svetlenkaja.travelagency.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public abstract class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

}
