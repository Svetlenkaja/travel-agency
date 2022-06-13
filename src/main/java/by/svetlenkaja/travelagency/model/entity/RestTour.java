//package by.svetlenkaja.travelagency.model.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//
//@Data
//@Entity
//@PrimaryKeyJoinColumn(name = "tour_id", referencedColumnName = "ID")
//@Table(name = "rest_tour")
//public class RestTour extends Tour{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @ManyToOne
//    @JoinColumn(name = "hotel_id")
//    private Hotel hotel;
//
//    @Column(name = "number_of_adults")
//    private int numberOfAdults;
//
//    @Column(name = "number_of_children")
//    private int numberOfChildren;
//
//    @ManyToOne
//    @JoinColumns({@JoinColumn(name = "room_type_location_principle_type", referencedColumnName = "type"),
//            @JoinColumn(name =  "room_type_location_principle_code", referencedColumnName = "code")})
//    private Classifier roomTypeLocationPrinciple;
//
//    @ManyToOne
//    @JoinColumns({@JoinColumn(name = "room_type_by_view_type", referencedColumnName = "type"),
//            @JoinColumn(name =  "room_type_by_view_code", referencedColumnName = "code")})
//    private Classifier roomTypeByView;
//}
