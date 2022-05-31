package by.svetlenkaja.travelagency.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table (name = "order")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_date")
    //add
    private LocalDateTime orderDate;

    @Column(name = "order_number")
    private String orderNumber;

    @OneToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @Column(name = "cost")
    private int cost;

    @Column(name = "discont")
    private int discont;

}
