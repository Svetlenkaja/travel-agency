package by.svetlenkaja.travelagency.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "tour_id", referencedColumnName = "ID")
@Table(name = "rest_tour")
public class RestTour extends Tour{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

}
