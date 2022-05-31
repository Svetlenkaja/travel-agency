package by.svetlenkaja.travelagency.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@PrimaryKeyJoinColumn(name = "tour_id", referencedColumnName = "ID")
@Table(name = "excursion_tour")
@Entity
public class ExcursionTour extends Tour{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "duration_type", referencedColumnName = "type"),
    @JoinColumn(name = "duration_code", referencedColumnName = "code")})
    private Classifier durationType;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "group_age_type", referencedColumnName = "type"),
            @JoinColumn(name = "group_age_code", referencedColumnName = "code")})
    private Classifier groupAgeType;



}
