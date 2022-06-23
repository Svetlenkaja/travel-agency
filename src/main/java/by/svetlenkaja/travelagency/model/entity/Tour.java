package by.svetlenkaja.travelagency.model.entity;

import by.svetlenkaja.travelagency.constant.ClassifierType;
import by.svetlenkaja.travelagency.constant.FoodType;
import by.svetlenkaja.travelagency.constant.TourType;
import by.svetlenkaja.travelagency.constant.TransportType;
import by.svetlenkaja.travelagency.utils.CustomLocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tour")

public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "tour_type")
    private int tourType;

    @Column(name = "tour_code")
    private int tourCode;

    @Transient
    private TourType type;

    @Column(name = "transport_type")
    private int transportType;

    @Column(name = "transport_code")
    private int transportCode;

    @Transient
    private TransportType transport;

    @Column(name = "food_type")
    private  int foodType;

    @Column(name="food_code")
    private int foodCode;

    @Transient
    private FoodType food;

    @Column(name = "date_of_departure")
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate dateOfDeparture;

    @Column(name = "number_of_nights")
    private int numberOfNights;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="state_type", referencedColumnName = "type"),
            @JoinColumn(name="state_code", referencedColumnName = "code")
    })
    private Classifier stateType;

    @Column(name="cost")
    private double cost;

    @Column(name="cost_with_discount")
    private double costWithDiscount;

    @Column(name="discount")
    private int discount;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @PostLoad
        void fillTransient(){
        if (tourCode > 0) {
            this.type = TourType.of(tourCode);
        }
        if (transportCode > 0) {
            this.transport = TransportType.of(transportCode);
        }
        if (foodCode > 0) {
            this.food = FoodType.of(foodCode);
        }
    }

    @PrePersist
    void fillPersistent() {
        if (type != null){
            this.tourType = ClassifierType.TOUR.getType();
            this.tourCode = type.getCode();
        }
        if (transport != null ) {
            this.transportType = ClassifierType.TRANSPORT.getType();
            this.transportCode = transport.getCode();
        }
        if (food != null ) {
            this.foodType = ClassifierType.FOOD.getType();
            this.foodCode = food.getCode();
        }
    }
}
