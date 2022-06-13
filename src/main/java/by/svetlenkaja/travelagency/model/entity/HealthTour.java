//package by.svetlenkaja.travelagency.model.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//
//@Data
//@PrimaryKeyJoinColumn(name = "tour_id", referencedColumnName = "ID")
//@Table(name = "health_tour")
//@Entity
//public class HealthTour extends Tour {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @ManyToOne
//    @JoinColumns({@JoinColumn(name = "therapy_type", referencedColumnName = "type"),
//            @JoinColumn(name = "therapy_code", referencedColumnName = "code")})
//    private Classifier therapyType;
//
//    @Column(name = "sanatorium_name")
//    private String sanatoriumName;
//
//    @ManyToOne
//    @JoinColumns({@JoinColumn(name = "room_type_location_principle_type", referencedColumnName = "type"),
//            @JoinColumn(name =  "room_type_location_principle_code", referencedColumnName = "code")})
//    private Classifier roomTypeLocationPrinciple;
//}
