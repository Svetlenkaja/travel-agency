package by.svetlenkaja.travelagency.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_role")
    private Role role;
    @Column
    private String surname;
    @Column
    private String name;
    @Column
    private String patronymic;
    @Column
    private String login;
}
