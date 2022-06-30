package by.svetlenkaja.travelagency.model.entity;

import by.svetlenkaja.travelagency.constant.*;
import by.svetlenkaja.travelagency.utils.CustomLocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="booking")
@Accessors(chain = true)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @CreationTimestamp
    @Column(name = "order_date")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private LocalDate orderDate;

    @Column(name="order_number")
    private String orderNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @Column(name = "customer_discount")
    private double customerDiscount;

    @Column(name = "total_cost")
    private double totalCost;

    @Column(name = "status_type")
    private int statusType;

    @Column(name = "status_code")
    private int statusCode;


    @Transient
    private BookingStatusType status;

    @PostLoad
    void fillTransient(){
        if (statusCode > 0) {
            this.status = BookingStatusType.of(statusCode);
        }
    }

    @PrePersist
    void fillPersistent() {
        if (status != null){
            this.statusType = ClassifierType.BOOKING_STATUS.getType();
            this.statusCode = status.getCode();
        }
    }
}
