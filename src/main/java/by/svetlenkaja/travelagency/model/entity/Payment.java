package by.svetlenkaja.travelagency.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name= "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
}
