package by.svetlenkaja.travelagency.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tour")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "tour_type", referencedColumnName = "type"),
            @JoinColumn(name = "tour_code", referencedColumnName = "code")
    })
    private Classifier typeTour;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "transport_type", referencedColumnName = "type"),
            @JoinColumn(name = "transport_code", referencedColumnName = "code")
    })
    private Classifier transportTour;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="food_type", referencedColumnName = "type"),
            @JoinColumn(name="food_code", referencedColumnName = "code")
    })
    private Classifier foodType;

    @Column(name = "date_of_departure")
    private LocalDate dateOfDeparture;

    @Column(name = "number_of_nights")
    private int numberOfNights;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="state_type", referencedColumnName = "type"),
            @JoinColumn(name="state_code", referencedColumnName = "code")
    })
    private Classifier stateType;

}
