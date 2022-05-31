package by.svetlenkaja.travelagency.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="hotel")
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "resort_id")
    private Resort resort;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="class_type", referencedColumnName = "type"),
            @JoinColumn(name="class_code", referencedColumnName = "code")
    })
    private Classifier classType;
}
