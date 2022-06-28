package by.svetlenkaja.travelagency.model.entity;

import by.svetlenkaja.travelagency.utils.CustomLocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @CreationTimestamp
    @Column(name = "order_date")
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime orderDate;

    @Column(name="order_number")
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @Column(name = "cost_with_sale")
    private double costWithSale;

    @Column(name = "personal_sale")
    private double personalSale;

    @Column(name = "status_type")
    private int statusType;

    @Column(name = "status_code")
    private int statusCode;

}
