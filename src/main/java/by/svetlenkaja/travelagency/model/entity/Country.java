package by.svetlenkaja.travelagency.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "country")
@Entity
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="visa")
    private boolean visa;

    public Country(long id) {
        this.id = id;
    }
}
